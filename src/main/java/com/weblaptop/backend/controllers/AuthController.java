package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.ENTITY.User;
import com.weblaptop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/login")
public class AuthController {
    @Autowired
    private UserService service;
    @RequestMapping(value = "/", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(@Validated @RequestBody User dto) {
        return service.login(dto);
    }
}
