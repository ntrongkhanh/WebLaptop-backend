package com.weblaptop.backend.models.DTO;

public class ManufacturerDTO {
    private long id;
    private String name;
    private long idImage;
    private String image;
    private long idProductType;
    private String productType;
    private String national;

    public ManufacturerDTO() {
    }

    public ManufacturerDTO(long id, String name, long idImage, String image, long idProductType,
                           String productType, String national) {
        this.id = id;
        this.name = name;
        this.idImage = idImage;
        this.image = image;
        this.idProductType = idProductType;
        this.productType = productType;
        this.national = national;
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

    public long getIdImage() {
        return idImage;
    }

    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(long idProductType) {
        this.idProductType = idProductType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }


    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }
}
