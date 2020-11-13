package com.weblaptop.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idProduct;
    private int star;

    public Rate() {
    }

    public Rate(long id, long idProduct, int star) {
        this.id = id;
        this.idProduct = idProduct;
        this.star = star;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
