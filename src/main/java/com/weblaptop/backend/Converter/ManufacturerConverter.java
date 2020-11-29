package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.ManufacturerDTO;
import com.weblaptop.backend.models.ENTITY.Manufacturer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManufacturerConverter {
    public Manufacturer toEntity(ManufacturerDTO dto){
        Manufacturer manufacturer=new Manufacturer();
        manufacturer.setId(dto.getId());
        manufacturer.setName(dto.getName());
        manufacturer.setNational(dto.getNational());
        return manufacturer;
    }
    public ManufacturerDTO toDTO(Manufacturer manufacturer){
        ManufacturerDTO dto=new ManufacturerDTO();
        dto.setId(manufacturer.getId());
        dto.setImage(manufacturer.getImage().getImage());
        dto.setNational(manufacturer.getNational());
        dto.setProductType(manufacturer.getProductType().getName());
        dto.setIdImage(manufacturer.getImage().getId());
        dto.setIdProductType(manufacturer.getProductType().getId());
        dto.setName(manufacturer.getName());
        return dto;
    }
    public List<ManufacturerDTO> toDTOs(List<Manufacturer> manufacturers){
        List<ManufacturerDTO> dtos=new ArrayList<>();
        for (Manufacturer manufacturer:manufacturers){
            dtos.add(this.toDTO(manufacturer));
        }
        return dtos;
    }
}
