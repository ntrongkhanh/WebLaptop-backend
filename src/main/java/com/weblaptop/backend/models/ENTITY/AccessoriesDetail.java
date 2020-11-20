package com.weblaptop.backend.models.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class AccessoriesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idAccessories", nullable = false)
    private Product accessories;
    private String name;
    private String content;

    public AccessoriesDetail() {
    }

    public AccessoriesDetail(long id, Product accessories, String name, String content) {
        this.id = id;
        this.accessories = accessories;
        this.name = name;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getAccessories() {
        return accessories;
    }

    public void setAccessories(Product accessories) {
        this.accessories = accessories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
