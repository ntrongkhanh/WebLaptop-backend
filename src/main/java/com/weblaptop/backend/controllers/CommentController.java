package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.DTO.CommentDto;
import com.weblaptop.backend.models.DTO.KeyboardDTO;
import com.weblaptop.backend.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@CrossOrigin(origins = "https://laptopre.herokuapp.com")
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService service;
    @GetMapping("/{idProduct}")
    public ResponseEntity<Map<String, Object>> getByProduct(@PathVariable(value = "idProduct") long id) {
        return service.getAllByProduct(id);
    }

    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody CommentDto dto) {
//        if (!jwtUtils.isAdmin(token))@RequestHeader("Authorization") String token,
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.create(dto);
    }
}
