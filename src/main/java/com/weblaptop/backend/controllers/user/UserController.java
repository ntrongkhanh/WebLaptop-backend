package com.weblaptop.backend.controllers.user;

import com.weblaptop.backend.models.DTO.OrdersDto;
import com.weblaptop.backend.models.ENTITY.OrdersEntity;
import com.weblaptop.backend.models.ENTITY.User;
import com.weblaptop.backend.repositories.UserRepository;
import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.services.AuthService;
import com.weblaptop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
@Autowired
private UserRepository userRepository;
    @Autowired
    private UserService service;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthService authService;
    // logout
    @GetMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        User user = jwtUtils.getUserByJwtToken(token);
        return authService.logout(user);
    }
    //order
    @RequestMapping(value = "/order", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> order(@RequestHeader("Authorization") String token,@Validated @RequestBody OrdersDto ordersDto) {
        User user = jwtUtils.getUserByJwtToken(token);
        return service.order(ordersDto,user);
    }
    //addProductToCart
    @RequestMapping(value = "/addProductToCart", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> addProductToCart(@RequestHeader("Authorization") String token,
                                                                @RequestParam(value = "idProduct") long idProduct,
                                                                @RequestParam(value = "idUser") long idUser,
                                                                @RequestParam(value = "amount") int amount) {
        User user = jwtUtils.getUserByJwtToken(token);
        return service.addProductToCart(idProduct, user, amount);
    }
    //deleteProductInCart
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteProductInCart(@RequestHeader("Authorization") String token,@PathVariable(value = "id") long id) {
        return service.deleteProductInCart(id);
    }
    //getCartByUser
    @GetMapping("/getCartByUser/{id}")
    public ResponseEntity<Map<String, Object>> getCartByUser(@RequestHeader("Authorization") String token,@PathVariable(value = "id") long idUser) {
        User user = jwtUtils.getUserByJwtToken(token);
        return service.getCartByUser(user);
    }
    //getAllOrderByUser
    @GetMapping("/getAllOrderByUser/{id}")
    public ResponseEntity<Map<String, Object>> getAllOrderByUser(@RequestHeader("Authorization") String token,@PathVariable(value = "id") long idUser) {
        User user = jwtUtils.getUserByJwtToken(token);
        return service.getAllOrderByUser(user);
    }
    //getOrderById
    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<Map<String, Object>> getOrderById(@RequestHeader("Authorization") String token,@PathVariable(value = "id") long id) {

        return service.getOrderById(id);
    }
}
