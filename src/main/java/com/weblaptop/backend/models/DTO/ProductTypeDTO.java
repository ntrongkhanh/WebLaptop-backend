package com.weblaptop.backend.models.DTO;

public class ProductTypeDTO {
    private long id;
    private String name;


    public ProductTypeDTO() {
    }

    public ProductTypeDTO(long id, String name) {
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
