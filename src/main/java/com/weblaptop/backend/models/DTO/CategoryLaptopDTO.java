package com.weblaptop.backend.models.DTO;

import com.weblaptop.backend.models.ENTITY.CategoryAccessoriesDetail;
import com.weblaptop.backend.models.ENTITY.Manufacturer;
import com.weblaptop.backend.models.ENTITY.Product;

import javax.persistence.OneToMany;
import java.util.List;

public class CategoryLaptopDTO {
    private long id;
    private String name;

    public CategoryLaptopDTO() {
    }

    public CategoryLaptopDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
