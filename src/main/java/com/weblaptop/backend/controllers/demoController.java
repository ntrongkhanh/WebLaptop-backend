package com.weblaptop.backend.controllers;


import com.weblaptop.backend.models.Product;
import com.weblaptop.backend.repositories.DemoRepository;
import com.weblaptop.backend.services.interfaces.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class demoController {
    @Autowired
    private IDemoService iDemoService;

    @Autowired
    private DemoRepository demoRepository;
//    @GetMapping("/")
//    public ResponseEntity<Map<String, Object>> getAll() {
//        return iDemoService.getAllDemo();
//    }

    @GetMapping("/a")
    public ResponseEntity<Map<String, Object>> getAll()
    {

        try {
            List<Product> dtoes = demoRepository.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("Laptop", dtoes);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
