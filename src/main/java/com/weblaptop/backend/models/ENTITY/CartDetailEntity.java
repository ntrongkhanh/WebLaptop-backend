package com.weblaptop.backend.models.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;

import javax.persistence.*;

@Entity
@Table(name = "orders_detail")
public class CartDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int amount;
    private long totalPrice;
    // cart
//
//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "idCart", nullable = true)
//    private CartEntity cartEntity;
    // product N 1
//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "idProduct", nullable = false)
//    private ProductEntity productEntity;
    @ManyToOne
    @JoinColumn(name="idProduct", nullable=false)
    private ProductEntity productEntity;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idOrder", nullable = true)
    private OrdersEntity ordersEntity;

    public CartDetailEntity() {
    }

    public CartDetailEntity(int amount, CartEntity cartEntity, ProductEntity productEntity) {
        this.amount = amount;
     //   this.cartEntity = cartEntity;
        this.productEntity = productEntity;
    }

    public CartDetailEntity(long id, int amount, long totalPrice, CartEntity cartEntity, ProductEntity productEntity, OrdersEntity ordersEntity) {
        this.id = id;
        this.amount = amount;
        this.totalPrice = totalPrice;
    //    this.cartEntity = cartEntity;
        this.productEntity = productEntity;
        this.ordersEntity = ordersEntity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CartDetailEntity(int amount, OrdersEntity ordersEntity, ProductEntity productEntity) {
        this.amount = amount;
        this.productEntity = productEntity;
        this.ordersEntity = ordersEntity;
    }

    public CartDetailEntity(long id, int amount, CartEntity cartEntity, ProductEntity productEntity, OrdersEntity ordersEntity) {
        this.id = id;
        this.amount = amount;
  //      this.cartEntity = cartEntity;
        this.productEntity = productEntity;
        this.ordersEntity = ordersEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

 //   public CartEntity getCartEntity() {
//        return cartEntity;
//    }
//
//    public void setCartEntity(CartEntity cartEntity) {
//        this.cartEntity = cartEntity;
//    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }
}
