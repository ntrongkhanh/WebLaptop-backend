package com.weblaptop.backend.services;

import com.weblaptop.backend.models.ENTITY.*;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.repositories.CartDetailRepository;
import com.weblaptop.backend.repositories.CartRepository;
import com.weblaptop.backend.repositories.OrdersRepository;
import com.weblaptop.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    // create user
    public ResponseEntity<Map<String,Object>> create(User user){
        try {
            user.setAdmin(false);
            user=userRepository.save(user);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // login
    public ResponseEntity<Map<String, Object>> login(User user){
        return null;
    }
    // đặt hàng
    public ResponseEntity<Map<String, Object>> order(OrdersEntity ordersEntity,long idProduct, long idUser, int amount){
        try {
            User user=entityManager.getReference(User.class,idUser);
            ordersEntity.setStatus("PENDING");
            ordersEntity.setUser(user);
            ordersEntity=ordersRepository.saveAndFlush(ordersEntity);
            ProductEntity productEntity=entityManager.getReference(ProductEntity.class,idProduct);
            CartDetailEntity cartDetailEntity=new CartDetailEntity(amount,ordersEntity,productEntity);
            cartDetailEntity=cartDetailRepository.saveAndFlush(cartDetailEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // thêm vào giỏ quà
    public ResponseEntity<Map<String, Object>> addProductToCart(long idProduct, long idUser, int amount){
        try {
            CartEntity cartEntity=cartRepository.findByUser(idUser).get();
            ProductEntity productEntity=entityManager.getReference(ProductEntity.class,idProduct);
            CartDetailEntity cartDetailEntity=new CartDetailEntity(amount,cartEntity,productEntity);
            cartDetailEntity=cartDetailRepository.saveAndFlush(cartDetailEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // xóa giỏ hàng
    public ResponseEntity<Map<String, Object>> deleteProductInCart(long idCartDetail){
        Map<String, Object> response = new HashMap<>();
        Optional<CartDetailEntity> cartDetailEntity = cartDetailRepository.findById(idCartDetail);
        if (!cartDetailEntity.isPresent()) {
            response.put("data", "Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        try {
            cartDetailRepository.deleteById(idCartDetail);
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("data", "Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    // xem thông tin giỏ hàng
    public ResponseEntity<Map<String, Object>> getCartByUser(long idUser){

        try {
            Optional<CartEntity> dtos = cartRepository.findByUser(idUser);
            Map<String, Object> response = new HashMap<>();
            response.put("data", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // get all order
    public ResponseEntity<Map<String, Object>> getAllOrder(){
        try {
            List<OrdersEntity> dtos = ordersRepository.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("data", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // xem thông tin đặt hàng
    public ResponseEntity<Map<String, Object>> getAllOrderByUser(long idUser){
        try {
            List<OrdersEntity> dtos = ordersRepository.findAllByUser(idUser);
            Map<String, Object> response = new HashMap<>();
            response.put("data", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Map<String, Object>> getOrderById(long idOrder){
        try {
            Optional<OrdersEntity> dtos = ordersRepository.findById(idOrder);
            Map<String, Object> response = new HashMap<>();
            response.put("data", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // xử lý đặt hàng
    public ResponseEntity<Map<String, Object>> handleOrder(long idOrder, String status){
        try {
            Optional<OrdersEntity> optional = ordersRepository.findById(idOrder);
            if (!optional.isPresent()){
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            OrdersEntity dto=optional.get();
            dto.setStatus(status);
            dto=ordersRepository.save(dto);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
