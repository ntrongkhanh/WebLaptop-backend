package com.weblaptop.backend.models.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.weblaptop.backend.models.ENTITY.CartDetailEntity;
import com.weblaptop.backend.models.ENTITY.User;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class OrdersDto {
    private long id;
    private String name;
    private String address;
    private String phone;
    private String status;
    private long idUser;
    private long totalPrice;
    // cart detail
    private List<CartDetailDto> cartDetailDtos;

    public OrdersDto() {
    }

    public OrdersDto(long id, String name, String address, String phone, String status, List<CartDetailDto> cartDetailDtos) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.cartDetailDtos = cartDetailDtos;
    }

    public OrdersDto(long id, String name, String address, String phone, String status, long idUser, List<CartDetailDto> cartDetailDtos) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.idUser = idUser;
        this.cartDetailDtos = cartDetailDtos;
    }

    public OrdersDto(long id, String name, String address, String phone, String status, long idUser, long totalPrice, List<CartDetailDto> cartDetailDtos) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.idUser = idUser;
        this.totalPrice = totalPrice;
        this.cartDetailDtos = cartDetailDtos;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CartDetailDto> getCartDetailDtos() {
        return cartDetailDtos;
    }

    public void setCartDetailDtos(List<CartDetailDto> cartDetailDtos) {
        this.cartDetailDtos = cartDetailDtos;
    }
}
