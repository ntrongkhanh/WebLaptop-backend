package com.weblaptop.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String logo;
    private boolean isLaptop;
    private String national;

    public Manufacturer() {
    }

    public Manufacturer(long id, String name, String logo, boolean isLaptop, String national) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.isLaptop = isLaptop;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isLaptop() {
        return isLaptop;
    }

    public void setLaptop(boolean laptop) {
        isLaptop = laptop;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }
}
