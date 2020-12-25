package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/laptop")
public class LaptopManagementController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return laptopService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return laptopService.getById(id);
    }


}
