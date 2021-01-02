package com.weblaptop.backend.models.ENTITY.Product;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Laptop")
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String cpu;
    private String ram;
    private String screen;
    private String graphicCard;
    private String storage;
    private String battery;
    private String port;
    private String OS;
    //    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "idProduct", nullable = false)
//    private ProductEntity productEntity;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct", referencedColumnName = "id")
    private ProductEntity productEntity;

    public LaptopEntity() {
    }

    public LaptopEntity(long id, String cpu, String ram, String screen, String graphicCard, String storage,
                        String battery, String port, String OS, ProductEntity productEntity) {
        this.id = id;
        this.cpu = cpu;
        this.ram = ram;
        this.screen = screen;
        this.graphicCard = graphicCard;
        this.storage = storage;
        this.battery = battery;
        this.port = port;
        this.OS = OS;
        this.productEntity = productEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public ProductEntity getProduct() {
        return productEntity;
    }

    public void setProduct(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
