package com.weblaptop.backend.services;


import com.weblaptop.backend.Converter.ImageConverter;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Image;
import com.weblaptop.backend.repositories.ImageRepo;
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
    private ImageRepo imageRepo;
    @Autowired
    private ImageConverter converter;
    public ResponseEntity<Map<String, Object>> create(ImageDTO imageDTO){

        try {

            Image image=converter.toEntity(imageDTO);
            image =imageRepo.save(image);
            Map<String, Object> response = new HashMap<>();
            response.put("Image", image);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Map<String, Object>>  getAll() {
        try {
            List<ImageDTO> imageDTOS = converter.toDTOs(imageRepo.findAll());
            Map<String, Object> response = new HashMap<>();
            response.put("Images", imageDTOS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public void delete(long id)   {
        try{
            imageRepo.deleteById(id);
        }
        catch (Exception e){
            return;
        }
    }

    public ResponseEntity<Map<String, Object>>  update(ImageDTO imageDTO) {
        Image image=converter.toEntity(imageDTO);
        Optional<Image> imageOptional = imageRepo.findById(image.getId());
        if (!imageOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        imageRepo.saveAndFlush(image);
        Map<String, Object> response = new HashMap<>();
        response.put("Image", image);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>>  getById(long id) {
        try {
            Optional<Image> image=imageRepo.findById(id);
            if (!image.isPresent()){
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            ImageDTO imageDTO=new ImageDTO();
            imageDTO.setId(image.get().getId());
            imageDTO.setImage(image.get().getImage());
            Map<String, Object> response = new HashMap<>();
            response.put("Image", imageDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
