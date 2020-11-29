package com.weblaptop.backend.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class demoController {


    @GetMapping("/")
    public String get(){
        return "hello";
    }


//    @GetMapping("/")
//    public ResponseEntity<Map<String, Object>> getAll() {
//        return iDemoService.getAllDemo();
//    }


//    @GetMapping("/c")
//    public ResponseEntity<Map<String, Object>> c()
//    {
//
//        try {
//            ArrayList<Product> dtoes = (ArrayList<Product>) productRepository.findAll();
//            Map<String, Object> response = new HashMap<>();
//            response.put("Laptop", dtoes);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @GetMapping("/a")
//    public ResponseEntity<Map<String, Object>> getAll()
//    {
//
//        try {
//            ArrayList<LaptopDetail> dtoes = (ArrayList<LaptopDetail>) demoRepository.findAll();
//            Map<String, Object> response = new HashMap<>();
//            response.put("Laptop", dtoes);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @GetMapping("/b")
//    public ResponseEntity<Map<String, Object>> get()
//    {
//        try {
//            ArrayList<LaptopDTO> dtoes = (ArrayList<LaptopDTO>) demoService.getAlldemo();
//            Map<String, Object> response = new HashMap<>();
//            response.put("Laptop", dtoes);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
