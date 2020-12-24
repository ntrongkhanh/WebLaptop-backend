package com.weblaptop.backend.models.ENTITY.Product;

import javax.persistence.*;
@Entity
@Table(name = "KeyboardEntity")
public class KeyboardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String size;
    private String standardConnection;
    private String connectionProtocol;
    private String led;
    private String _switch;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct", referencedColumnName = "id")
    private ProductEntity productEntity;

    public KeyboardEntity() {
    }

    public KeyboardEntity(long id, String size, String standardConnection, String connectionProtocol, String led,
                          String _switch, ProductEntity productEntity) {
        this.id = id;
        this.size = size;
        this.standardConnection = standardConnection;
        this.connectionProtocol = connectionProtocol;
        this.led = led;
        this._switch = _switch;
        this.productEntity = productEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getLed() {
        return led;
    }

    public void setLed(String led) {
        this.led = led;
    }

    public String get_switch() {
        return _switch;
    }

    public void set_switch(String _switch) {
        this._switch = _switch;
    }

    public ProductEntity getProduct() {
        return productEntity;
    }

    public void setProduct(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
