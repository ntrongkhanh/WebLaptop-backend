package com.weblaptop.backend.services;


import com.weblaptop.backend.Converter.ProductTypeConverter;
import com.weblaptop.backend.models.DTO.ProductTypeDTO;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.ProductTypeRepository;
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
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductTypeConverter converter;


    public ResponseEntity<Map<String, Object>> create(ProductTypeDTO dto) {

        try {
            ProductTypeEntity productTypeEntity = converter.toEntity(dto);
            productTypeEntity = productTypeRepository.save(productTypeEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<ProductTypeDTO> productTypeDTOList = converter.toDTOs(productTypeRepository.findAll());
            Map<String, Object> response = new HashMap<>();
            response.put("data", productTypeDTOList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> delete(long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            productTypeRepository.deleteById(id);
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("data", "Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }


    }

    public ResponseEntity<Map<String, Object>> update(ProductTypeDTO dto) {
        try {
            ProductTypeEntity productTypeEntity = converter.toEntity(dto);
            Optional<ProductTypeEntity> imageOptional = productTypeRepository.findById(dto.getId());
            if (!imageOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            productTypeRepository.save(productTypeEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", productTypeEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<ProductTypeEntity> productType = productTypeRepository.findById(id);
            if (!productType.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            ProductTypeDTO dto = new ProductTypeDTO();
            dto.setId(productType.get().getId());
            dto.setName(productType.get().getName());
            Map<String, Object> response = new HashMap<>();
            response.put("data", productType);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
