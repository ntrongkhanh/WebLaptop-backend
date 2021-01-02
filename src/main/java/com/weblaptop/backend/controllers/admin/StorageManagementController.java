package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.models.DTO.StorageDTO;
import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/storage")
public class StorageManagementController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private StorageService StorageService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll(@RequestHeader("Authorization") String token) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return StorageService.getAll();
    }

    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@RequestHeader("Authorization") String token, @Validated @RequestBody StorageDTO dto) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return StorageService.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@RequestHeader("Authorization") String token, @PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return StorageService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@RequestHeader("Authorization") String token, @PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return StorageService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestHeader("Authorization") String token, @RequestBody StorageDTO dto) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return StorageService.update(dto);
    }
}
