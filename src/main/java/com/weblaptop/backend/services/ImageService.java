package com.weblaptop.backend.services;


import com.weblaptop.backend.Converter.ImageConverter;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageConverter converter;

    public ResponseEntity<Map<String, Object>> create(ImageDTO imageDTO) {
        try {
            ImageEntity imageEntity = converter.toEntity(imageDTO);
            imageEntity = imageRepository.save(imageEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<ImageDTO> imageDTOS = converter.toDTOs(imageRepository.findAll());
            Map<String, Object> response = new HashMap<>();
            response.put("data", imageDTOS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> delete(long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            imageRepository.deleteById(id);
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("data", "Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    public ResponseEntity<Map<String, Object>> update(ImageDTO imageDTO) {
        ImageEntity imageEntity = converter.toEntity(imageDTO);
        Optional<ImageEntity> imageOptional = imageRepository.findById(imageEntity.getId());
        if (!imageOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        imageRepository.saveAndFlush(imageEntity);
        Map<String, Object> response = new HashMap<>();
        response.put("data", "Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<ImageEntity> image = imageRepository.findById(id);
            if (!image.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setId(image.get().getId());
            imageDTO.setImage(image.get().getImage());
            Map<String, Object> response = new HashMap<>();
            response.put("data", imageDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
