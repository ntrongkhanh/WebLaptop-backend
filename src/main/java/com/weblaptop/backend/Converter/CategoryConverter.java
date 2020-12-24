package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.CategoryDTO;
import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {
    public CategoryEntity toEntity(CategoryDTO dto){
        CategoryEntity categoryEntity =new CategoryEntity();
        categoryEntity.setId(dto.getId());
        categoryEntity.setName(dto.getName());

        return categoryEntity;
    }
    public CategoryDTO toDTO(CategoryEntity categoryEntity){
        CategoryDTO dto=new CategoryDTO();
        dto.setId(categoryEntity.getId());
        dto.setName(categoryEntity.getName());
        dto.setIdProductType(categoryEntity.getId());
        dto.setProdctType(categoryEntity.getName());
        return dto;
    }
    public List<CategoryDTO> toDTOs(List<CategoryEntity> categories){
        List<CategoryDTO> dtos=new ArrayList<>();
        for (CategoryEntity categoryEntity :categories){
            dtos.add(this.toDTO(categoryEntity));
        }
        return dtos;
    }
}
