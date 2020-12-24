package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImageConverter {
    public ImageEntity toEntity(ImageDTO dto){
        ImageEntity imageEntity =new ImageEntity();
        imageEntity.setId(dto.getId());
        imageEntity.setImage(dto.getImage());
        return imageEntity;
    }
    public ImageDTO toDTO(ImageEntity imageEntity){
        ImageDTO dto=new ImageDTO();
        dto.setId(imageEntity.getId());
        dto.setImage(imageEntity.getImage());
        return dto;
    }
    public List<ImageDTO> toDTOs(List<ImageEntity> list){
        List<ImageDTO> imageDTOS=new ArrayList<>();
        for (ImageEntity imageEntity :list){
            imageDTOS.add(this.toDTO(imageEntity));
        }
        return imageDTOS;
    }
}
