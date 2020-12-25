package com.weblaptop.backend.controllers.user;

import com.weblaptop.backend.models.ENTITY.OrdersEntity;
import com.weblaptop.backend.models.ENTITY.User;
import com.weblaptop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/auth/user")
public class UserController {

    @Autowired
    private UserService service;

    //order
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> order(@Validated @RequestBody OrdersEntity ordersEntity, @Validated @RequestBody long idProduct, @Validated @RequestBody long idUser, @Validated @RequestBody int amount) {
        return service.order(ordersEntity, idProduct, idUser, amount);
    }
    //addProductToCart
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> addProductToCart(@PathVariable(value = "idProduct") long idProduct,
                                                                @PathVariable(value = "idUser") long idUser,
                                                                @PathVariable(value = "amount") int amount) {
        return service.addProductToCart(idProduct, idUser, amount);
    }
    //deleteProductInCart
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteProductInCart(@PathVariable(value = "id") long id) {
        return service.deleteProductInCart(id);
    }
    //getCartByUser
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getCartByUser(@PathVariable(value = "idUser") long idUser) {
        return service.getCartByUser(idUser);
    }
    //getAllOrderByUser
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAllOrderByUser(@PathVariable(value = "idUser") long idUser) {
        return service.getAllOrderByUser(idUser);
    }
    //getOrderById
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getOrderById(@PathVariable(value = "idUser") long idUser) {
        return service.getCartByUser(idUser);
    }

}
