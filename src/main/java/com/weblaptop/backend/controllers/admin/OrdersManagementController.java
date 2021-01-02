package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.services.CategoryService;
import com.weblaptop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/order")
public class OrdersManagementController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private UserService service;
    @Autowired
    private CategoryService categoryService;

    //handleOrder
    @GetMapping("/handleOrder")
    public ResponseEntity<Map<String, Object>> handleOrder(@RequestHeader("Authorization") String token, @PathVariable(value = "id") long id, @PathVariable(value = "status") String status) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.handleOrder(id,status);
    }
    //getOrderById
    @GetMapping("/getOrderById")
    public ResponseEntity<Map<String, Object>> getOrderById(@RequestHeader("Authorization") String token, @PathVariable(value = "idUser") long idUser) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.getOrderById(idUser);
    }
    //getAllOrder
    @GetMapping("/getAllOrder")
    public ResponseEntity<Map<String, Object>> getAllOrder(@RequestHeader("Authorization") String token) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.getAllOrder();
    }

}
