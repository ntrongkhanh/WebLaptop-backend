package com.weblaptop.backend.models.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idUser;
    private long priceTotal;

//    public Cart() {
//    }
//
//    public Cart(long id, long idUser, long priceTotal) {
//        this.id = id;
//        this.idUser = idUser;
//        this.priceTotal = priceTotal;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(long idUser) {
//        this.idUser = idUser;
//    }
//
//    public long getPriceTotal() {
//        return priceTotal;
//    }
//
//    public void setPriceTotal(long priceTotal) {
//        this.priceTotal = priceTotal;
//    }
}
