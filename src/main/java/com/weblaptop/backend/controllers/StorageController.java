package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.DTO.RamDTO;
import com.weblaptop.backend.models.DTO.StorageDTO;
import com.weblaptop.backend.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "https://laptopre.herokuapp.com")
@RequestMapping("/api/storage")
public class StorageController {
    @Autowired
    private StorageService StorageService;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return StorageService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return StorageService.getById(id);
    }
}
