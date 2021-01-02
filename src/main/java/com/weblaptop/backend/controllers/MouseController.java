package com.weblaptop.backend.controllers;


import com.weblaptop.backend.models.DTO.MouseDTO;
import com.weblaptop.backend.models.DTO.RamDTO;
import com.weblaptop.backend.services.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/mouse")
public class MouseController {
    @Autowired
    private MouseService MouseService;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return  MouseService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return MouseService.getById(id);
    }
}
