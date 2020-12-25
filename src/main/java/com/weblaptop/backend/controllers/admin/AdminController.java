package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth/admin")
public class AdminController {
    @Autowired
    private UserService service;

    //handleOrder
    @GetMapping("/handleOrder")
    public ResponseEntity<Map<String, Object>> handleOrder(@PathVariable(value = "id") long id, @PathVariable(value = "status") String status) {
        return service.handleOrder(id,status);
    }
    //getOrderById
    @GetMapping("/getOrderById")
    public ResponseEntity<Map<String, Object>> getOrderById(@PathVariable(value = "idUser") long idUser) {
        return service.getCartByUser(idUser);
    }
    //getAllOrder
    @GetMapping("/getAllOrder")
    public ResponseEntity<Map<String, Object>> getAllOrder() {
        return service.getAllOrder();
    }
}
