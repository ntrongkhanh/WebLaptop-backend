package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.CategoryConverter;
import com.weblaptop.backend.models.DTO.CategoryDTO;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Image;
import com.weblaptop.backend.models.ENTITY.ProductType;
import com.weblaptop.backend.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryConverter converter;
    @Autowired
    private CategoryRepo repo;
    @Autowired
    private EntityManager entityManager;
    public ResponseEntity<Map<String, Object>> create(CategoryDTO dto){

        try {
            Category category=converter.toEntity(dto);
            ProductType productType=entityManager.getReference(ProductType.class,dto.getIdProductType());
            category.setProductType(productType);
            category=repo.save(category);
            Map<String, Object> response = new HashMap<>();
            response.put("Category", category);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Map<String, Object>>  getAll() {
        try {
            List<CategoryDTO> categoryList = converter.toDTOs(repo.findAll());
            Map<String, Object> response = new HashMap<>();
            response.put("Categories", categoryList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public void delete(long id)   {
        try{
            repo.deleteById(id);
        }catch (Exception e){
            return;
        }

    }

    public ResponseEntity<Map<String, Object>>  update(CategoryDTO dto) {
        Category category=converter.toEntity(dto);
        Optional<Category> imageOptional = repo.findById(dto.getId());
        if (!imageOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        repo.save(category);
        Map<String, Object> response = new HashMap<>();
        response.put("Category", category);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>>  getById(long id) {
        try {
            Optional<Category> category=repo.findById(id);
            if (!category.isPresent()){
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            CategoryDTO dto=new CategoryDTO();
            dto.setId(category.get().getId());
            dto.setName(category.get().getName());
            Map<String, Object> response = new HashMap<>();
            response.put("Image", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
