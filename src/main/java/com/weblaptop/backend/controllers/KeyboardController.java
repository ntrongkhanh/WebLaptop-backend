package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.DTO.KeyboardDTO;
import com.weblaptop.backend.services.KeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/keyboard")
public class KeyboardController {
    @Autowired
    private KeyboardService KeyboardService;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return  KeyboardService.getAll();
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody KeyboardDTO dto) {
        return KeyboardService.create(dto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return KeyboardService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void detele(@PathVariable(value = "id") long id) {
        KeyboardService.delete(id);
    }
}
