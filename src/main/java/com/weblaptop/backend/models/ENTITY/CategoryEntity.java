package com.weblaptop.backend.models.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idProductType", nullable = true)
    private ProductTypeEntity productTypeEntity;
//    @OneToMany(mappedBy = "category")
//    private List<ManufacturerEntity> manufacturers;
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> productEntities;
    public CategoryEntity() {
    }

    public CategoryEntity(long id, String name, ProductTypeEntity productTypeEntity,
                          List<ProductEntity> productEntities) {
        this.id = id;
        this.name = name;
        this.productTypeEntity = productTypeEntity;
//        this.manufacturers = manufacturers;
        this.productEntities = productEntities;
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

    public ProductTypeEntity getProductType() {
        return productTypeEntity;
    }

    public void setProductType(ProductTypeEntity productTypeEntity) {
        this.productTypeEntity = productTypeEntity;
    }


    public List<ProductEntity> getProducts() {
        return productEntities;
    }

    public void setProducts(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }
}
