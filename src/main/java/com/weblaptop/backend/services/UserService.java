package com.weblaptop.backend.services;

import com.weblaptop.backend.models.DTO.CartDetailDto;
import com.weblaptop.backend.models.DTO.CartDto;
import com.weblaptop.backend.models.DTO.OrdersDto;
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

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.*;

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


    // đặt hàng
    public ResponseEntity<Map<String, Object>> order(OrdersDto ordersDto, User user) {
        try {
            long totalPrice = 0;
         //   Optional<User> user = userRepository.findById(us);
            OrdersEntity ordersEntity = new OrdersEntity();
            ordersEntity.setAddress(ordersDto.getAddress());
            ordersEntity.setStatus("Chờ");
            ordersEntity.setName(ordersDto.getName());
            ordersEntity.setPhone(ordersDto.getPhone());
            ordersEntity.setUser(user);
            ordersEntity = ordersRepository.saveAndFlush(ordersEntity);
            List<CartDetailEntity> cartDetailList = new ArrayList<>();
            for (int i = 0; i < ordersDto.getCartDetailDtos().size(); i++) {
                ProductEntity productEntity = entityManager.getReference(ProductEntity.class, ordersDto.getCartDetailDtos().get(i).getIdProduct());

                CartDetailEntity cartDetailEntity = new CartDetailEntity();
                cartDetailEntity.setAmount(ordersDto.getCartDetailDtos().get(i).getAmount());
                cartDetailEntity.setProductEntity(productEntity);
                cartDetailEntity.setOrdersEntity(ordersEntity);
                cartDetailEntity.setTotalPrice(productEntity.getPrice() * cartDetailEntity.getAmount());
                totalPrice+=cartDetailEntity.getTotalPrice();
                cartDetailEntity = cartDetailRepository.saveAndFlush(cartDetailEntity);
            }
            ordersEntity.setTotalPrice(totalPrice);
            ordersEntity = ordersRepository.save(ordersEntity);


//            ordersEntity.setStatus("Chờ");
//            ordersEntity.setUser(user);
//            ordersEntity=ordersRepository.saveAndFlush(ordersEntity);
//            ProductEntity productEntity=entityManager.getReference(ProductEntity.class,idProduct);
//            CartDetailEntity cartDetailEntity=new CartDetailEntity(amount,ordersEntity,productEntity);
//            cartDetailEntity=cartDetailRepository.saveAndFlush(cartDetailEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // thêm vào giỏ quà
    public ResponseEntity<Map<String, Object>> addProductToCart(long idProduct, User user, int amount) {
        try {
            Optional<CartEntity> cartEntity = cartRepository.findByUser(user.getId());
            ProductEntity productEntity = entityManager.getReference(ProductEntity.class, idProduct);
            CartDetailEntity cartDetailEntity = new CartDetailEntity(amount, cartEntity.get(), productEntity);
            cartDetailEntity.setTotalPrice(cartDetailEntity.getAmount() * cartDetailEntity.getProductEntity().getPrice());
            cartDetailEntity = cartDetailRepository.saveAndFlush(cartDetailEntity);
            cartEntity.get().setTotalPrice(cartDetailEntity.getTotalPrice() + cartDetailEntity.getTotalPrice());
            cartRepository.save(cartEntity.get());
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // xóa giỏ hàng
    public ResponseEntity<Map<String, Object>> deleteProductInCart(long idCartDetail) {
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
    public ResponseEntity<Map<String, Object>> getCartByUser(User user) {

        try {
            long totalPrice = 0;
            Optional<CartEntity> dtos = cartRepository.findByUser(user.getId());
            List<CartDetailDto> detailDtoList = new ArrayList<>();
            for (int i = 0; i < dtos.get().getCartDetailEntities().size(); i++) {
                CartDetailDto cartDetailDto = new CartDetailDto();
                cartDetailDto.setId(dtos.get().getCartDetailEntities().get(i).getId());
                cartDetailDto.setIdProduct(dtos.get().getCartDetailEntities().get(i).getProductEntity().getId());
                cartDetailDto.setAmount(dtos.get().getCartDetailEntities().get(i).getAmount());
                cartDetailDto.setImage(dtos.get().getCartDetailEntities().get(i).getProductEntity().getImageEntity().getImage());
                cartDetailDto.setName(dtos.get().getCartDetailEntities().get(i).getProductEntity().getName());
                cartDetailDto.setPrice(dtos.get().getCartDetailEntities().get(i).getProductEntity().getPrice());
                cartDetailDto.setTotalPrice(cartDetailDto.getPrice()*cartDetailDto.getAmount());
           //   totalPrice += cartDetailDto.getTotalPrice();
                detailDtoList.add(cartDetailDto);
//                detailDtoList.add(dtos.get().getCartDetailEntities(i).get(.get))
            }

            CartDto cartDto = new CartDto();
            cartDto.setId(dtos.get().getId());
            cartDto.setCartDetailDtos(detailDtoList);
            cartDto.setTotalPrice(dtos.get().getTotalPrice());

            Map<String, Object> response = new HashMap<>();
            response.put("data", cartDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // xem thông tin đặt hàng
    public ResponseEntity<Map<String, Object>> getAllOrderByUser(User user) {
        try {

            List<OrdersEntity> dtos = ordersRepository.findAllByUser(user.getId());
            List<OrdersDto> list=new ArrayList<>();
            for (OrdersEntity ordersEntity:dtos){
                long totalPrice=0;
                List<CartDetailDto> detailDtoList = new ArrayList<>();
                for (int i = 0; i < ordersEntity.getCartDetailEntities().size(); i++) {
                    CartDetailDto cartDetailDto = new CartDetailDto();
                    cartDetailDto.setId(ordersEntity.getCartDetailEntities().get(i).getId());
                    cartDetailDto.setIdProduct(ordersEntity.getCartDetailEntities().get(i).getProductEntity().getId());
                    cartDetailDto.setAmount(ordersEntity.getCartDetailEntities().get(i).getAmount());
                    cartDetailDto.setImage(ordersEntity.getCartDetailEntities().get(i).getProductEntity().getImageEntity().getImage());
                    cartDetailDto.setName(ordersEntity.getCartDetailEntities().get(i).getProductEntity().getName());
                    cartDetailDto.setPrice(ordersEntity.getCartDetailEntities().get(i).getProductEntity().getPrice());
                    cartDetailDto.setTotalPrice(cartDetailDto.getPrice()*cartDetailDto.getAmount());
            //        totalPrice += cartDetailDto.getTotalPrice();
                    detailDtoList.add(cartDetailDto);
//                detailDtoList.add(dtos.get().getCartDetailEntities(i).get(.get))
                }
                OrdersDto ordersDto = new OrdersDto();
                ordersDto.setId(ordersEntity.getId());
                ordersDto.setCartDetailDtos(detailDtoList);
                ordersDto.setTotalPrice(ordersEntity.getTotalPrice());
                ordersDto.setStatus(ordersEntity.getStatus());
                ordersDto.setPhone(ordersEntity.getPhone());
                ordersDto.setName(ordersEntity.getName());
                list.add(ordersDto);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("data", list);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get all order
    public ResponseEntity<Map<String, Object>> getAllOrder() {
        try {
            List<OrdersEntity> dtos = ordersRepository.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("data", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getOrderById(long idOrder) {
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
    public ResponseEntity<Map<String, Object>> handleOrder(long idOrder, String status) {
        try {
            Optional<OrdersEntity> optional = ordersRepository.findById(idOrder);
            if (!optional.isPresent()) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            OrdersEntity dto = optional.get();
            dto.setStatus(status);
            dto = ordersRepository.save(dto);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
