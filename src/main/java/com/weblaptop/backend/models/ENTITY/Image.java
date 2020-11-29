package com.weblaptop.backend.models.ENTITY;

import com.weblaptop.backend.models.ENTITY.Product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;
    @OneToMany(mappedBy = "image")
    private List<Manufacturer> manufacturers;
    @OneToMany(mappedBy = "image")
    private List<Product> products;
    public Image() {
    }

    public Image(long id, String image, List<Manufacturer> manufacturers, List<Product> products) {
        this.id = id;
        this.image = image;
        this.manufacturers = manufacturers;
        this.products = products;
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

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
