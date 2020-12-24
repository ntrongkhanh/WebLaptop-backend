package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.ImageConverter;
import com.weblaptop.backend.Converter.ManufacturerConverter;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.DTO.ManufacturerDTO;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.ImageRepository;
import com.weblaptop.backend.repositories.ManufacturerRepository;
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
    private ManufacturerRepository repo;
    @Autowired
    private ManufacturerConverter converter;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private ImageRepository imageRepository;

    //, ImageDTO imageDTO
    public ResponseEntity<Map<String, Object>> create(ManufacturerDTO dto) {
        // ImageEntity image=imageConverter.toEntity(imageDTO);
        ManufacturerEntity manufacturerEntity = converter.toEntity(dto);
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImage(dto.getImage());

        try {
            ImageEntity imageEntity = imageConverter.toEntity(imageDTO);
            imageEntity = imageRepository.saveAndFlush(imageEntity);

            ProductTypeEntity productTypeEntity = entityManager.getReference(ProductTypeEntity.class, dto.getIdProductType());
            manufacturerEntity.setProductType(productTypeEntity);
            manufacturerEntity.setImage(imageEntity);
            manufacturerEntity = repo.save(manufacturerEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<ManufacturerDTO> manufacturerDTOS = converter.toDTOs(repo.findAll());
            Map<String, Object> response = new HashMap<>();
            response.put("data", manufacturerDTOS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>>  delete(long id) {
        Map<String, Object> response = new HashMap<>();
        try{
            repo.deleteById(id);
            response.put("data","Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("data","Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }


    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<ManufacturerEntity> manufacturer = repo.findById(id);
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
            response.put("data", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
