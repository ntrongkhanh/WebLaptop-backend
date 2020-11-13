package com.weblaptop.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idManufacturer;
    private long idCategory;
    private String modelCode;
    private String name;
    private boolean isLaptop;
    private Date year;
    private long idImage;
    private String status;
    private long amount;
    private long price;

    public Product() {
    }

    public Product(long id, long idManufacturer, long idCategory, String modelCode, String name, boolean isLaptop, Date year, long idImage, String status, long amount, long price) {
        this.id = id;
        this.idManufacturer = idManufacturer;
        this.idCategory = idCategory;
        this.modelCode = modelCode;
        this.name = name;
        this.isLaptop = isLaptop;
        this.year = year;
        this.idImage = idImage;
        this.status = status;
        this.amount = amount;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(long idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLaptop() {
        return isLaptop;
    }

    public void setLaptop(boolean laptop) {
        isLaptop = laptop;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public long getIdImage() {
        return idImage;
    }

    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
