package com.weblaptop.backend.models.ENTITY.Product;

import javax.persistence.*;
@Entity
@Table(name = "RamEntity")
public class RamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String capacity;
    private String buss;
    private String Voltage;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct", referencedColumnName = "id")
    private ProductEntity productEntity;

    public RamEntity() {
    }

    public RamEntity(long id, String capacity, String buss, String voltage, ProductEntity productEntity) {
        this.id = id;
        this.capacity = capacity;
        this.buss = buss;
        Voltage = voltage;
        this.productEntity = productEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBuss() {
        return buss;
    }

    public void setBuss(String buss) {
        this.buss = buss;
    }

    public String getVoltage() {
        return Voltage;
    }

    public void setVoltage(String voltage) {
        Voltage = voltage;
    }

    public ProductEntity getProduct() {
        return productEntity;
    }

    public void setProduct(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
