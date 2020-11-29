package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.CategoryDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {
    public Category toEntity(CategoryDTO dto){
        Category category=new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());

        return category;
    }
    public CategoryDTO toDTO(Category category){
        CategoryDTO dto=new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setIdProductType(category.getId());
        dto.setProdctType(category.getName());
        return dto;
    }
    public List<CategoryDTO> toDTOs(List<Category> categories){
        List<CategoryDTO> dtos=new ArrayList<>();
        for (Category category:categories){
            dtos.add(this.toDTO(category));
        }
        return dtos;
    }
}
