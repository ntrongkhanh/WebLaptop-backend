package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.CategoryConverter;
import com.weblaptop.backend.models.DTO.CategoryDTO;
import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.CategoryRepository;
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
    private CategoryRepository repo;
    @Autowired
    private EntityManager entityManager;

    public ResponseEntity<Map<String, Object>> create(CategoryDTO dto) {

        try {
            CategoryEntity categoryEntity = converter.toEntity(dto);
            ProductTypeEntity productTypeEntity = entityManager.getReference(ProductTypeEntity.class, dto.getIdProductType());
            categoryEntity.setProductType(productTypeEntity);
            categoryEntity = repo.save(categoryEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<CategoryDTO> categoryList = converter.toDTOs(repo.findAll());
            Map<String, Object> response = new HashMap<>();
            response.put("data", categoryList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> delete(long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            repo.deleteById(id);
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("data", "Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    public ResponseEntity<Map<String, Object>> update(CategoryDTO dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            CategoryEntity categoryEntity = converter.toEntity(dto);
            Optional<CategoryEntity> imageOptional = repo.findById(dto.getId());
            if (!imageOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            repo.save(categoryEntity);
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<CategoryEntity> category = repo.findById(id);
            if (!category.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            CategoryDTO dto = new CategoryDTO();
            dto.setId(category.get().getId());
            dto.setName(category.get().getName());
            Map<String, Object> response = new HashMap<>();
            response.put("data", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
