package com.weblaptop.backend.models.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.weblaptop.backend.models.ENTITY.Product.Product;

import javax.persistence.*;
import java.util.List;
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idImage", nullable = false)
    private Image image;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idProductType", nullable = true)
    private ProductType productType;

    private String national;
    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(long id, String name, Image image, ProductType productType,
                        String national, List<Product> products) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.productType = productType;

        this.national = national;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
