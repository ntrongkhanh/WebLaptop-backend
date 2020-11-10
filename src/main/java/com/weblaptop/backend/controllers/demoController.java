package com.weblaptop.backend.controllers;


import com.weblaptop.backend.repositories.DemoRepository;
import com.weblaptop.backend.services.interfaces.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class demoController {
    @Autowired
    private IDemoService iDemoService;

    @Autowired
    private DemoRepository studentRepository;
//    @GetMapping("/")
//    public ResponseEntity<Map<String, Object>> getAll() {
//        return iDemoService.getAllDemo();
//    }

    @GetMapping("/")
    public String getAll() {
        return iDemoService.getAlldemo();
    }

}
