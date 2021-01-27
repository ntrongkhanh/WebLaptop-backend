package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.models.DTO.MouseDTO;
import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.services.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
@RestController
@CrossOrigin(origins = "https://laptopre.herokuapp.com")
@RequestMapping("/admin/mouse")
public class MouseManagementController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private MouseService MouseService;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll(@RequestHeader("Authorization") String token) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return  MouseService.getAll();
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@RequestHeader("Authorization") String token, @Validated @RequestBody MouseDTO dto) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return MouseService.create(dto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@RequestHeader("Authorization") String token, @PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return MouseService.getById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@RequestHeader("Authorization") String token, @PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return MouseService.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestHeader("Authorization") String token, @RequestBody MouseDTO dto) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return MouseService.update(dto);
    }
}
