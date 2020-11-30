package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return  imageService.getAll();
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody ImageDTO imageDTO) {
        return imageService.create(imageDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return imageService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        imageService.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody ImageDTO imageDTO)  {
        return imageService.update(imageDTO);
    }
}
