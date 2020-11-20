package com.weblaptop.backend.services.Implements;

import com.weblaptop.backend.Converter.CategoryLaptopConverter;
import com.weblaptop.backend.models.DTO.CategoryLaptopDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.repositories.CategoryRepository;
import com.weblaptop.backend.services.interfaces.ICategoryService;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.relation.RelationException;
import java.net.URI;
import java.util.*;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryLaptopConverter converter;

    @Override
    public ResponseEntity<Map<String, Object>>  createCategoryLaptop(CategoryLaptopDTO categoryLaptopDTO){

        try {

            Category savedCategory = categoryRepository.save(converter.toEntity(categoryLaptopDTO));
            Map<String, Object> response = new HashMap<>();
            response.put("Category", savedCategory);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void deleteCategoryLaptop(long id)   {

        categoryRepository.deleteById(id);
        //        try {
//            categoryRepository.deleteById(id);
//            return new ResponseEntity<>(null, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }

    }

    @Override
    public ResponseEntity<Map<String, Object>>  updateCategoryLaptop(CategoryLaptopDTO categoryLaptopDTO) {
        Category category=converter.toEntity(categoryLaptopDTO);
        Optional<Category> categoryOptional = categoryRepository.findById(categoryLaptopDTO.getId());
        if (!categoryOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        categoryRepository.save(category);
        Map<String, Object> response = new HashMap<>();
        response.put("category", category);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    @Override
    public ResponseEntity<Map<String, Object>>  getAllCategoryLaptop() {
        try {
            List<CategoryLaptopDTO> categoryList = converter.toDTOs(categoryRepository.findAll());

            Map<String, Object> response = new HashMap<>();
            response.put("categories", categoryList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>>  getByIdCategoryLaptop(long id) {
        try {
            Optional<Category> category=categoryRepository.findById(id);
            CategoryLaptopDTO categoryLaptopDTO=new CategoryLaptopDTO();
            categoryLaptopDTO.setId(category.get().getId());
            categoryLaptopDTO.setName(category.get().getName());
            Map<String, Object> response = new HashMap<>();
            response.put("categorie", categoryLaptopDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>>  getByNameCategoryLaptop(String name) {
        try {
            List<CategoryLaptopDTO> categoryList = converter.toDTOs(categoryRepository.getByName(name));
            Map<String, Object> response = new HashMap<>();
            response.put("categories",categoryList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
