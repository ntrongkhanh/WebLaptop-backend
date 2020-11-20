package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.CategoryLaptopDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryLaptopConverter {
    public Category toEntity(CategoryLaptopDTO categoryLaptopDTO) {
        Category category=new Category();
        category.setId(categoryLaptopDTO.getId());
        category.setLaptop(true);
        category.setName(categoryLaptopDTO.getName());
        return category;
    }
    public CategoryLaptopDTO toDTO(Category category) {
        CategoryLaptopDTO categoryLaptopDTO=new CategoryLaptopDTO();
        categoryLaptopDTO.setId(category.getId());
        categoryLaptopDTO.setName(category.getName());
        return categoryLaptopDTO;
    }
    public List<CategoryLaptopDTO> toDTOs(List<Category> categoryList) {
        List<CategoryLaptopDTO> categoryLaptopDTOS=new ArrayList<>();
        for (Category category:categoryList){
            categoryLaptopDTOS.add(this.toDTO(category));
        }
        return categoryLaptopDTOS;
    }
}
