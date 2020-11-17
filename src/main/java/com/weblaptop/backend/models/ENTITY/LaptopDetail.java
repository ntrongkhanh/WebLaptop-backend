package com.weblaptop.backend.models.ENTITY;

import javax.persistence.*;

@Entity
public class LaptopDetail {
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
    private String weight;
    private String OS;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProduct", nullable = false)
    private Product product;

    public LaptopDetail() {
    }

    public LaptopDetail(long id, String cpu, String ram, String screen, String graphicCard, String storage,
                        String battery, String port, String weight, String OS, Product product) {
        this.id = id;
        this.cpu = cpu;
        this.ram = ram;
        this.screen = screen;
        this.graphicCard = graphicCard;
        this.storage = storage;
        this.battery = battery;
        this.port = port;
        this.weight = weight;
        this.OS = OS;
        this.product = product;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
