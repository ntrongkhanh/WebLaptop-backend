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
@RequestMapping("/api/laptop")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return  laptopService.getAll();
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
    public void detele(@PathVariable(value = "id") long id) {
        laptopService.delete(id);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Map<String, Object>> update(@RequestBody ImageDTO imageDTO)  {
//        return laptopService.update(imageDTO);
//    }
}
