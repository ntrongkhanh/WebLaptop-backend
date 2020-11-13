package com.weblaptop.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccessoriesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idAccessories;
    private String name;
    private String content;

    public AccessoriesDetail() {
    }

    public AccessoriesDetail(long id, long idAccessories, String name, String content) {
        this.id = id;
        this.idAccessories = idAccessories;
        this.name = name;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAccessories() {
        return idAccessories;
    }

    public void setIdAccessories(long idAccessories) {
        this.idAccessories = idAccessories;
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
