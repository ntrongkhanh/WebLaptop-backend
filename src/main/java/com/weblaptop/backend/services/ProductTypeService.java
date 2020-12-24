package com.weblaptop.backend.services;


import com.weblaptop.backend.Converter.ProductTypeConverter;
import com.weblaptop.backend.models.DTO.ProductTypeDTO;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.ProductTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepo productTypeRepo;
    @Autowired
    private ProductTypeConverter converter;


    public ResponseEntity<Map<String, Object>> create(ProductTypeDTO dto) {

        try {
            ProductTypeEntity productTypeEntity = converter.toEntity(dto);
            productTypeEntity = productTypeRepo.save(productTypeEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("ProductTypeController", productTypeEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<ProductTypeDTO> productTypeDTOList = converter.toDTOs(productTypeRepo.findAll());
            Map<String, Object> response = new HashMap<>();
            response.put("ProductTypeController", productTypeDTOList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> delete(long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            productTypeRepo.deleteById(id);
            response.put("data", "delete success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("data", "delete failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }


    }

    public ResponseEntity<Map<String, Object>> update(ProductTypeDTO dto) {
        ProductTypeEntity productTypeEntity = converter.toEntity(dto);
        Optional<ProductTypeEntity> imageOptional = productTypeRepo.findById(dto.getId());
        if (!imageOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        productTypeRepo.save(productTypeEntity);
        Map<String, Object> response = new HashMap<>();
        response.put("ProductTypeController", productTypeEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<ProductTypeEntity> productType = productTypeRepo.findById(id);
            if (!productType.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            ProductTypeDTO dto = new ProductTypeDTO();
            dto.setId(productType.get().getId());
            dto.setName(productType.get().getName());
            Map<String, Object> response = new HashMap<>();
            response.put("ProductTypeController", productType);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
