package com.weblaptop.backend.models.DTO;

public class CategoryDTO {
    private long id;
    private String name;
    private long idProductType;
    private String prodctType;
    public CategoryDTO() {
    }

    public CategoryDTO(long id, String name, long idProductType, String prodctType) {
        this.id = id;
        this.name = name;
        this.idProductType = idProductType;
        this.prodctType = prodctType;
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

    public long getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(long idProductType) {
        this.idProductType = idProductType;
    }

    public String getProdctType() {
        return prodctType;
    }

    public void setProdctType(String prodctType) {
        this.prodctType = prodctType;
    }
}
