package com.weblaptop.backend.models.ENTITY;

import com.weblaptop.backend.models.ENTITY.Product.Product;

import javax.persistence.*;
import java.util.List;
// Laptop Ram ,..
@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(mappedBy = "productType")
    private List<Manufacturer> productType;
    @OneToMany(mappedBy = "productType")
    private List<Product> products;
    @OneToMany(mappedBy = "productType")
    private List<Category> categories;

    public ProductType() {
    }

    public ProductType(long id, String name, List<Manufacturer> productType, List<Product> products,
                       List<Category> categories) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.products = products;
        this.categories = categories;
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

    public List<Manufacturer> getProductType() {
        return productType;
    }

    public void setProductType(List<Manufacturer> productType) {
        this.productType = productType;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
