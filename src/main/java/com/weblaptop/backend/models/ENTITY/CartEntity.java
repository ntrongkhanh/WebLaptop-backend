package com.weblaptop.backend.models.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long totalPrice;

    // user N 1
//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "idUser", nullable = true)
//    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private User user;
    // detail cart 1 N

    @OneToMany(mappedBy = "cartEntity")
    private List<CartDetailEntity> cartDetailEntities;

    public CartEntity() {
    }

    public CartEntity(long id, long totalPrice, User user, List<CartDetailEntity> cartDetailEntities) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.user = user;
        this.cartDetailEntities = cartDetailEntities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartDetailEntity> getCartDetailEntities() {
        return cartDetailEntities;
    }

    public void setCartDetailEntities(List<CartDetailEntity> cartDetailEntities) {
        this.cartDetailEntities = cartDetailEntities;
    }
}
