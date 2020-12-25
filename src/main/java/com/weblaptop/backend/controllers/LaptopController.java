package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.services.ImageService;
import com.weblaptop.backend.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/laptop")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return laptopService.getAll();
    }

    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody LaptopDTO dto) {
        return laptopService.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return laptopService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable(value = "id") long id) {
        return laptopService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody LaptopDTO dto) {
        return laptopService.update(dto);
    }
}
