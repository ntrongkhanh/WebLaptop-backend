package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.ProductTypeDTO;
import com.weblaptop.backend.models.ENTITY.ProductType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductTypeConverter {
    public ProductType toEntity(ProductTypeDTO dto){
        ProductType productType=new ProductType();
        productType.setId(dto.getId());
        productType.setName(dto.getName());
        return productType;
    }
    public ProductTypeDTO toDTO(ProductType productType){
        ProductTypeDTO dto=new ProductTypeDTO();
        dto.setId(productType.getId());
        dto.setName(productType.getName());
        return dto;
    }
    public List<ProductTypeDTO> toDTOs(List<ProductType> productTypes){
        List<ProductTypeDTO> dtos=new ArrayList<>();
        for (ProductType productType:productTypes){
            dtos.add(this.toDTO(productType));
        }
        return dtos;
    }
}
