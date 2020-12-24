package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.ProductTypeDTO;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductTypeConverter {
    public ProductTypeEntity toEntity(ProductTypeDTO dto){
        ProductTypeEntity productTypeEntity =new ProductTypeEntity();
        productTypeEntity.setId(dto.getId());
        productTypeEntity.setName(dto.getName());
        return productTypeEntity;
    }
    public ProductTypeDTO toDTO(ProductTypeEntity productTypeEntity){
        ProductTypeDTO dto=new ProductTypeDTO();
        dto.setId(productTypeEntity.getId());
        dto.setName(productTypeEntity.getName());
        return dto;
    }
    public List<ProductTypeDTO> toDTOs(List<ProductTypeEntity> productTypeEntities){
        List<ProductTypeDTO> dtos=new ArrayList<>();
        for (ProductTypeEntity productTypeEntity : productTypeEntities){
            dtos.add(this.toDTO(productTypeEntity));
        }
        return dtos;
    }
}
