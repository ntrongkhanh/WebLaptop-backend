package com.weblaptop.backend.services.interfaces;

import com.weblaptop.backend.services.Implements.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface IDemoService {
    //  public ResponseEntity<Map<String, Object>> createDemo(demoModel demoModel);

   // public ResponseEntity<Map<String, Object>> getAllDemo();

    public String getAlldemo();
}
