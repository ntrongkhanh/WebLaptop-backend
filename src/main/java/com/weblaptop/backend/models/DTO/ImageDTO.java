package com.weblaptop.backend.models.DTO;

public class ImageDTO {
    private long id;
    private String image;

    public ImageDTO() {
    }

    public ImageDTO(long id, String image) {
        this.id = id;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
