package com.weblaptop.backend.models.ENTITY;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weblaptop.backend.models.ENTITY.Product.RamEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String name;
    private Boolean isAdmin = false;
    private String token;
    private Boolean isActive=false;
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private CartEntity cartEntity;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<OrdersEntity> ordersEntities;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<CommentEntity> commentEntity;

    public User() {
    }

    public User(String email, String password, String name, Boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public User(String email, String password, String name, Boolean isAdmin, Boolean isActive) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
    }

    public User(Long id, String email, String password, String name, Boolean isAdmin) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public User(Long id, String email, String password, String name, Boolean isAdmin, String token, CartEntity cartEntity, List<OrdersEntity> ordersEntities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
        this.token = token;
        this.cartEntity = cartEntity;
        this.ordersEntities = ordersEntities;
    }

    public User(Long id, String email, String password, String name, Boolean isAdmin, String token, Boolean isActive, CartEntity cartEntity, List<OrdersEntity> ordersEntities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
        this.token = token;
        this.isActive = isActive;
        this.cartEntity = cartEntity;
        this.ordersEntities = ordersEntities;
    }

    public User(Long id, String email, String password, String name, Boolean isAdmin, String token, Boolean isActive, CartEntity cartEntity, List<OrdersEntity> ordersEntities, List<CommentEntity> commentEntity) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
        this.token = token;
        this.isActive = isActive;
        this.cartEntity = cartEntity;
        this.ordersEntities = ordersEntities;
        this.commentEntity = commentEntity;
    }

    public List<CommentEntity> getCommentEntity() {
        return commentEntity;
    }

    public void setCommentEntity(List<CommentEntity> commentEntity) {
        this.commentEntity = commentEntity;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User(Long id, String email, String password, String name, Boolean isAdmin, CartEntity cartEntity, List<OrdersEntity> ordersEntities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
        this.cartEntity = cartEntity;
        this.ordersEntities = ordersEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public CartEntity getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
    }

    public List<OrdersEntity> getOrdersEntities() {
        return ordersEntities;
    }

    public void setOrdersEntities(List<OrdersEntity> ordersEntities) {
        this.ordersEntities = ordersEntities;
    }
}
