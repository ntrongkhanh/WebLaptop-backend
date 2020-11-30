package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.ImageConverter;
import com.weblaptop.backend.Converter.ManufacturerConverter;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.DTO.ManufacturerDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Image;
import com.weblaptop.backend.models.ENTITY.Manufacturer;
import com.weblaptop.backend.models.ENTITY.ProductType;
import com.weblaptop.backend.repositories.ImageRepo;
import com.weblaptop.backend.repositories.ManufacturerRepo;
import com.weblaptop.backend.repositories.ProductTypeRepo;
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
public class ManufacturerService {
    @Autowired
    private ManufacturerRepo repo;
    @Autowired
    private ManufacturerConverter converter;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private ImageRepo imageRepo;

    //, ImageDTO imageDTO
    public ResponseEntity<Map<String, Object>> create(ManufacturerDTO dto) {
        // Image image=imageConverter.toEntity(imageDTO);
        Manufacturer manufacturer = converter.toEntity(dto);
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImage(dto.getImage());

        try {
            Image imageEntity = imageConverter.toEntity(imageDTO);
            imageEntity = imageRepo.saveAndFlush(imageEntity);

            ProductType productType = entityManager.getReference(ProductType.class, dto.getIdProductType());
            manufacturer.setProductType(productType);
            manufacturer.setImage(imageEntity);
            manufacturer = repo.save(manufacturer);
            Map<String, Object> response = new HashMap<>();
            response.put("Manufacturer", manufacturer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<ManufacturerDTO> manufacturerDTOS = converter.toDTOs(repo.findAll());
            Map<String, Object> response = new HashMap<>();
            response.put("Manufacturer", manufacturerDTOS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delete(long id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            return;
        }

    }


    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<Manufacturer> manufacturer = repo.findById(id);
            if (!manufacturer.isPresent()){
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            ManufacturerDTO dto = new ManufacturerDTO();
            dto.setId(manufacturer.get().getId());
            dto.setImage(manufacturer.get().getImage().getImage());
            dto.setProductType(manufacturer.get().getProductType().getName());
            dto.setNational(manufacturer.get().getNational());
            dto.setName(manufacturer.get().getName());
            Map<String, Object> response = new HashMap<>();
            response.put("Image", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
