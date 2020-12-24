package com.weblaptop.backend.models.ENTITY;

import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;
    @OneToMany(mappedBy = "image")
    private List<ManufacturerEntity> manufacturerEntities;
    @OneToMany(mappedBy = "image")
    private List<ProductEntity> productEntities;
    public ImageEntity() {
    }

    public ImageEntity(long id, String image, List<ManufacturerEntity> manufacturerEntities, List<ProductEntity> productEntities) {
        this.id = id;
        this.image = image;
        this.manufacturerEntities = manufacturerEntities;
        this.productEntities = productEntities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ManufacturerEntity> getManufacturers() {
        return manufacturerEntities;
    }

    public void setManufacturers(List<ManufacturerEntity> manufacturerEntities) {
        this.manufacturerEntities = manufacturerEntities;
    }

    public List<ProductEntity> getProducts() {
        return productEntities;
    }

    public void setProducts(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }
}
