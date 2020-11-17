package com.weblaptop.backend.models.ENTITY;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "image",  columnDefinition="TEXT")
    private String image;

    public Image() {
    }

    public Image(long id, String image) {
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
