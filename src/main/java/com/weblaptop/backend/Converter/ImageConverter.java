package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.ENTITY.Image;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImageConverter {
    public Image toEntity(ImageDTO dto){
        Image image=new Image();
        image.setId(dto.getId());
        image.setImage(dto.getImage());
        return image;
    }
    public ImageDTO toDTO(Image image){
        ImageDTO dto=new ImageDTO();
        dto.setId(image.getId());
        dto.setImage(image.getImage());
        return dto;
    }
    public List<ImageDTO> toDTOs(List<Image> list){
        List<ImageDTO> imageDTOS=new ArrayList<>();
        for (Image image:list){
            imageDTOS.add(this.toDTO(image));
        }
        return imageDTOS;
    }
}
