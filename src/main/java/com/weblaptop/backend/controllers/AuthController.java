package com.weblaptop.backend.controllers;

import com.weblaptop.backend.mailConfig.MailService;
import com.weblaptop.backend.models.ENTITY.OrdersEntity;
import com.weblaptop.backend.models.ENTITY.User;
import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "https://laptopre.herokuapp.com")
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService service;
    @Autowired
    private JwtUtils jwtUtils;
    @RequestMapping(value = "/login", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<?> login(@Validated @RequestBody User dto) {
        return service.login(dto);
    }

    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody User dto) {
        return service.create(dto);
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public ResponseEntity<?> confirm(@RequestParam("token") String token, @RequestParam("email") String email) {
        return service.confirm(token, email);
    }
}
