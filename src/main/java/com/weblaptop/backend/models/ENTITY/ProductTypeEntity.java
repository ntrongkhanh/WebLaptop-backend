package com.weblaptop.backend.models.ENTITY;

import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;

import javax.persistence.*;
import java.util.List;
// LaptopEntity RamEntity ,..
@Entity
@Table(name = "Product_type")
public class ProductTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(mappedBy = "productTypeEntity")
    private List<ManufacturerEntity> productType;
    @OneToMany(mappedBy = "productTypeEntity")
    private List<ProductEntity> productEntities;
    @OneToMany(mappedBy = "productTypeEntity")
    private List<CategoryEntity> categories;

    public ProductTypeEntity() {
    }

    public ProductTypeEntity(long id, String name, List<ManufacturerEntity> productType, List<ProductEntity> productEntities,
                             List<CategoryEntity> categories) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.productEntities = productEntities;
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

    public List<ManufacturerEntity> getProductType() {
        return productType;
    }

    public void setProductType(List<ManufacturerEntity> productType) {
        this.productType = productType;
    }

    public List<ProductEntity> getProducts() {
        return productEntities;
    }

    public void setProducts(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
