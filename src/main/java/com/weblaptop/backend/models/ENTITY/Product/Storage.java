package com.weblaptop.backend.models.ENTITY.Product;

import javax.persistence.*;
@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String capacity;
    private String connectionProtocol;
    private String readSpeed;
    private String writeSpeed;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct", referencedColumnName = "id")
    private Product product;

    public Storage() {
    }

    public Storage(long id, String capacity, String connectionProtocol, String readSpeed, String writeSpeed,
                   Product product) {
        this.id = id;
        this.capacity = capacity;
        this.connectionProtocol = connectionProtocol;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
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

    public String getConnectionProtocol() {
        return connectionProtocol;
    }

    public void setConnectionProtocol(String connectionProtocol) {
        this.connectionProtocol = connectionProtocol;
    }

    public String getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(String readSpeed) {
        this.readSpeed = readSpeed;
    }

    public String getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(String writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
