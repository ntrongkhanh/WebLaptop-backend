package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.DTO.RamDTO;
import com.weblaptop.backend.services.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ram")
public class RamController {
    @Autowired
    private RamService RamService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return RamService.getAll();
    }

    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody RamDTO dto) {
        return RamService.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return RamService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        RamService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody RamDTO dto) {
        return RamService.update(dto);
    }
}
