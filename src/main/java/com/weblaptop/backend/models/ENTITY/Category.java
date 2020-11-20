package com.weblaptop.backend.models.ENTITY;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private boolean isLaptop;
    @OneToMany(mappedBy = "category")
    private List<CategoryAccessoriesDetail> categoryAccessoriesDetails;
    @OneToMany(mappedBy = "category")
    private List<Manufacturer> manufacturers;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    public Category() {
    }

    public Category(long id, String name, boolean isLaptop, List<CategoryAccessoriesDetail> categoryAccessoriesDetails,
                    List<Manufacturer> manufacturers,List<Product> product) {
        this.id = id;
        this.name = name;
        this.isLaptop = isLaptop;
        this.categoryAccessoriesDetails = categoryAccessoriesDetails;
        this.manufacturers = manufacturers;
        this.products=product;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    public boolean isLaptop() {
        return isLaptop;
    }

    public void setLaptop(boolean laptop) {
        isLaptop = laptop;
    }

    public List<CategoryAccessoriesDetail> getCategoryAccessoriesDetails() {
        return categoryAccessoriesDetails;
    }

    public void setCategoryAccessoriesDetails(List<CategoryAccessoriesDetail> categoryAccessoriesDetails) {
        this.categoryAccessoriesDetails = categoryAccessoriesDetails;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }
}
