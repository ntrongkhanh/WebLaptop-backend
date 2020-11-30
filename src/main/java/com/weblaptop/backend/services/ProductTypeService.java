package com.weblaptop.backend.services;


import com.weblaptop.backend.Converter.ProductTypeConverter;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.DTO.ProductTypeDTO;
import com.weblaptop.backend.models.ENTITY.Image;
import com.weblaptop.backend.models.ENTITY.ProductType;
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


    public ResponseEntity<Map<String, Object>> create(ProductTypeDTO dto){

        try {
            ProductType productType=converter.toEntity(dto);
            productType=productTypeRepo.save(productType);
            Map<String, Object> response = new HashMap<>();
            response.put("ProductTypeController", productType);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Map<String, Object>>  getAll() {
        try {
            List<ProductTypeDTO> productTypeDTOList = converter.toDTOs(productTypeRepo.findAll());
            Map<String, Object> response = new HashMap<>();
            response.put("ProductTypeController", productTypeDTOList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public void delete(long id)   {
        try {
            productTypeRepo.deleteById(id);
        }catch (Exception e){
            return;
        }

    }

    public ResponseEntity<Map<String, Object>>  update(ProductTypeDTO dto) {
        ProductType productType=converter.toEntity(dto);
        Optional<ProductType> imageOptional = productTypeRepo.findById(dto.getId());
        if (!imageOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        productTypeRepo.save(productType);
        Map<String, Object> response = new HashMap<>();
        response.put("ProductTypeController", productType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>>  getById(long id) {
        try {
            Optional<ProductType> productType=productTypeRepo.findById(id);
            if (!productType.isPresent()){
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            ProductTypeDTO dto=new ProductTypeDTO();
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
