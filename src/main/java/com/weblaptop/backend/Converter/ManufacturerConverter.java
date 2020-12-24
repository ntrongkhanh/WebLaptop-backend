package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.ManufacturerDTO;
import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManufacturerConverter {
    public ManufacturerEntity toEntity(ManufacturerDTO dto){
        ManufacturerEntity manufacturerEntity =new ManufacturerEntity();
        manufacturerEntity.setId(dto.getId());
        manufacturerEntity.setName(dto.getName());
        manufacturerEntity.setNational(dto.getNational());
        return manufacturerEntity;
    }
    public ManufacturerDTO toDTO(ManufacturerEntity manufacturerEntity){
        ManufacturerDTO dto=new ManufacturerDTO();
        dto.setId(manufacturerEntity.getId());
        dto.setImage(manufacturerEntity.getImage().getImage());
        dto.setNational(manufacturerEntity.getNational());
        dto.setProductType(manufacturerEntity.getProductType().getName());
        dto.setIdImage(manufacturerEntity.getImage().getId());
        dto.setIdProductType(manufacturerEntity.getProductType().getId());
        dto.setName(manufacturerEntity.getName());
        return dto;
    }
    public List<ManufacturerDTO> toDTOs(List<ManufacturerEntity> manufacturerEntities){
        List<ManufacturerDTO> dtos=new ArrayList<>();
        for (ManufacturerEntity manufacturerEntity : manufacturerEntities){
            dtos.add(this.toDTO(manufacturerEntity));
        }
        return dtos;
    }
}
