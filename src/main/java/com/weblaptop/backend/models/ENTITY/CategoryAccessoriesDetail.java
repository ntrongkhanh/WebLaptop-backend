package com.weblaptop.backend.models.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class CategoryAccessoriesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCategory", nullable = false)
    private Category category;
    private String name;

    public CategoryAccessoriesDetail() {
    }

    public CategoryAccessoriesDetail(long id, Category category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
