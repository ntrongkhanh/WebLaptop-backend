package com.weblaptop.backend.models.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Manufacturer")
public class ManufacturerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idImage", nullable = true)
    private ImageEntity imageEntity;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idProductType", nullable = true)
    private ProductTypeEntity productTypeEntity;

    private String national;
    @OneToMany(mappedBy = "manufacturerEntity")
    private List<ProductEntity> productEntities;

    public ManufacturerEntity() {
    }

    public ManufacturerEntity(long id, String name, ImageEntity imageEntity, ProductTypeEntity productTypeEntity,
                              String national, List<ProductEntity> productEntities) {
        this.id = id;
        this.name = name;
        this.imageEntity = imageEntity;
        this.productTypeEntity = productTypeEntity;

        this.national = national;
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

    public ImageEntity getImage() {
        return imageEntity;
    }

    public void setImage(ImageEntity imageEntity) {
        this.imageEntity = imageEntity;
    }

    public ProductTypeEntity getProductType() {
        return productTypeEntity;
    }

    public void setProductType(ProductTypeEntity productTypeEntity) {
        this.productTypeEntity = productTypeEntity;
    }


    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public List<ProductEntity> getProducts() {
        return productEntities;
    }

    public void setProducts(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }
}
