package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.models.DTO.KeyboardDTO;
import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.services.KeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
@RestController
@CrossOrigin(origins = "https://laptopre.herokuapp.com")
@RequestMapping("/admin/keyboard")
public class KeyboardManagementController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private KeyboardService KeyboardService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll(@RequestHeader("Authorization") String token) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return KeyboardService.getAll();
    }

    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@RequestHeader("Authorization") String token,@Validated @RequestBody KeyboardDTO dto) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return KeyboardService.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@RequestHeader("Authorization") String token,@PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return KeyboardService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@RequestHeader("Authorization") String token,@PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return KeyboardService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestHeader("Authorization") String token,@RequestBody KeyboardDTO dto) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return KeyboardService.update(dto);
    }

}
