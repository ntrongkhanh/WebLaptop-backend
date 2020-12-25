package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.models.DTO.StorageDTO;
import com.weblaptop.backend.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/storage")
public class StorageManagementController {
    @Autowired
    private StorageService StorageService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return StorageService.getAll();
    }

    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody StorageDTO dto) {
        return StorageService.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return StorageService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable(value = "id") long id) {
        return StorageService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody StorageDTO dto) {
        return StorageService.update(dto);
    }
}
