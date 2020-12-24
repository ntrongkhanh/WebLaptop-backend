package com.weblaptop.backend.models.ENTITY.Product;

import javax.persistence.*;
@Entity
@Table(name = "MouseEntity")
public class MouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String standardConnection;
    private String connectionProtocol;
    private String sensorEye;
    private String dpi;
    private String led;
    private String button;
    private String size;
    private String battery;
    private String os;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct", referencedColumnName = "id")
    private ProductEntity productEntity;

    public MouseEntity() {
    }

    public MouseEntity(long id, String standardConnection, String connectionProtocol, String sensorEye, String dpi,
                       String led, String button, String size, String battery, String os, ProductEntity productEntity) {
        this.id = id;
        this.standardConnection = standardConnection;
        this.connectionProtocol = connectionProtocol;
        this.sensorEye = sensorEye;
        this.dpi = dpi;
        this.led = led;
        this.button = button;
        this.size = size;
        this.battery = battery;
        this.os = os;
        this.productEntity = productEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStandardConnection() {
        return standardConnection;
    }

    public void setStandardConnection(String standardConnection) {
        this.standardConnection = standardConnection;
    }

    public String getConnectionProtocol() {
        return connectionProtocol;
    }

    public void setConnectionProtocol(String connectionProtocol) {
        this.connectionProtocol = connectionProtocol;
    }

    public String getSensorEye() {
        return sensorEye;
    }

    public void setSensorEye(String sensorEye) {
        this.sensorEye = sensorEye;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getLed() {
        return led;
    }

    public void setLed(String led) {
        this.led = led;
    }


    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }


    public ProductEntity getProduct() {
        return productEntity;
    }

    public void setProduct(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
