package com.weblaptop.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryAccessoriesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idCategory;
    private String name;

    public CategoryAccessoriesDetail() {
    }

    public CategoryAccessoriesDetail(long id, long idCategory, String name) {
        this.id = id;
        this.idCategory = idCategory;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
