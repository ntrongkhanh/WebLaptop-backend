package com.weblaptop.backend.controllers;


import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.models.ENTITY.LaptopDetail;
import com.weblaptop.backend.models.ENTITY.Product;
import com.weblaptop.backend.repositories.ProductRepository;
import com.weblaptop.backend.repositories.demorep2;
import com.weblaptop.backend.services.Implements.DemoService;
import com.weblaptop.backend.services.interfaces.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class demoController {
    @Autowired
    private IDemoService iDemoService;

    @Autowired
    private demorep2 demoRepository;
    @Autowired
    private DemoService demoService;
    @Autowired
    private ProductRepository productRepository;
//    @GetMapping("/")
//    public ResponseEntity<Map<String, Object>> getAll() {
//        return iDemoService.getAllDemo();
//    }


    @GetMapping("/c")
    public ResponseEntity<Map<String, Object>> c()
    {

        try {
            ArrayList<Product> dtoes = (ArrayList<Product>) productRepository.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("Laptop", dtoes);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/a")
    public ResponseEntity<Map<String, Object>> getAll()
    {

        try {
            ArrayList<LaptopDetail> dtoes = (ArrayList<LaptopDetail>) demoRepository.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("Laptop", dtoes);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/b")
    public ResponseEntity<Map<String, Object>> get()
    {
        try {
            ArrayList<LaptopDTO> dtoes = (ArrayList<LaptopDTO>) demoService.getAlldemo();
            Map<String, Object> response = new HashMap<>();
            response.put("Laptop", dtoes);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
