package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.models.DTO.CategoryDTO;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.services.CategoryService;
import com.weblaptop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/order")
public class OrdersManagementController {
    @Autowired
    private UserService service;
    @Autowired
    private CategoryService categoryService;

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
