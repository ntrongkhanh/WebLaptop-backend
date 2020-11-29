package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.DTO.StorageDTO;
import com.weblaptop.backend.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/storage")
public class StorageController {
    @Autowired
    private com.weblaptop.backend.services.StorageService StorageService;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return  StorageService.getAll();
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody StorageDTO dto) {
        return StorageService.create(dto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return StorageService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void detele(@PathVariable(value = "id") long id) {
        StorageService.delete(id);
    }
}
