package com.weblaptop.backend.controllers;

import com.weblaptop.backend.models.DTO.CategoryLaptopDTO;
import com.weblaptop.backend.repositories.CategoryRepository;
import com.weblaptop.backend.services.Implements.CategoryService;
import com.weblaptop.backend.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationException;
import java.util.Map;

@RestController
@RequestMapping("/api/categorylaptop")
public class CategoryLaptopController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return (ResponseEntity<Map<String, Object>>) categoryService.getAllCategoryLaptop();
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody CategoryLaptopDTO categoryLaptopDTO) {
        return categoryService.createCategoryLaptop(categoryLaptopDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return categoryService.getByIdCategoryLaptop(id);
    }
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Map<String, Object>> getByName(@PathVariable(value = "name") String name) {
        return categoryService.getByNameCategoryLaptop(name);
    }
    @DeleteMapping("/{id}")
    public void detele(@PathVariable(value = "id") long id) {
         categoryService.deleteCategoryLaptop(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody CategoryLaptopDTO categoryLaptopDTO)  {
        return categoryService.updateCategoryLaptop(categoryLaptopDTO);
    }
}
