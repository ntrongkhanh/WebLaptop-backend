package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.DTO.CategoryDTO;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.repositories.CategoryRepo;
import com.weblaptop.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService service;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return  service.getAll();
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody CategoryDTO dto) {
        return service.create(dto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void detele(@PathVariable(value = "id") long id) {
        service.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody CategoryDTO dto)  {
        return service.update(dto);
    }
}
