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
@RequestMapping("/api/mouse")
public class MouseController {
    @Autowired
    private MouseService MouseService;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return  MouseService.getAll();
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody MouseDTO dto) {
        return MouseService.create(dto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return MouseService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        MouseService.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody MouseDTO dto) {
        return MouseService.update(dto);
    }
}
