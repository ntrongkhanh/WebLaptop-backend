package com.weblaptop.backend.models.ENTITY.Product;

import javax.persistence.*;
@Entity
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String capacity;
    private String buss;
    private String Voltage;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct", referencedColumnName = "id")
    private Product product;

    public Ram() {
    }

    public Ram(long id,String capacity, String buss, String voltage, Product product) {
        this.id = id;
        this.capacity = capacity;
        this.buss = buss;
        Voltage = voltage;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
