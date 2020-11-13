package com.weblaptop.backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idCart;
    private boolean isLaptop;
    private long idProduct;

    public CartDetail() {
    }

    public CartDetail(long id, long idCart, boolean isLaptop, long idProduct) {
        this.id = id;
        this.idCart = idCart;
        this.isLaptop = isLaptop;
        this.idProduct = idProduct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCart() {
        return idCart;
    }

    public void setIdCart(long idCart) {
        this.idCart = idCart;
    }

    public boolean isLaptop() {
        return isLaptop;
    }

    public void setLaptop(boolean laptop) {
        isLaptop = laptop;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }
}
