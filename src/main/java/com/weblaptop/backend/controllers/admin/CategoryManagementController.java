package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.models.DTO.CategoryDTO;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/category")
public class CategoryManagementController {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private CategoryService service;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll(@RequestHeader("Authorization") String token) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@RequestHeader("Authorization") String token, @PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.getById(id);
    }

    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@RequestHeader("Authorization") String token, @Validated @RequestBody CategoryDTO imageDTO) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.create(imageDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@RequestHeader("Authorization") String token, @PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestHeader("Authorization") String token, @RequestBody CategoryDTO categoryDTO) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.update(categoryDTO);
    }

}
