package com.weblaptop.backend.models.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idCart;
    private Date orderDate;
    private Date receivedDate;
    private long idAddress;
    private String status;
    private String note;

//    public Orders() {
//    }
//
//    public Orders(long id, long idCart, Date orderDate, Date receivedDate, long idAddress, String status, String note) {
//        this.id = id;
//        this.idCart = idCart;
//        this.orderDate = orderDate;
//        this.receivedDate = receivedDate;
//        this.idAddress = idAddress;
//        this.status = status;
//        this.note = note;
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
//    public long getIdCart() {
//        return idCart;
//    }
//
//    public void setIdCart(long idCart) {
//        this.idCart = idCart;
//    }
//
//    public Date getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(Date orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public Date getReceivedDate() {
//        return receivedDate;
//    }
//
//    public void setReceivedDate(Date receivedDate) {
//        this.receivedDate = receivedDate;
//    }
//
//    public long getIdAddress() {
//        return idAddress;
//    }
//
//    public void setIdAddress(long idAddress) {
//        this.idAddress = idAddress;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
}
