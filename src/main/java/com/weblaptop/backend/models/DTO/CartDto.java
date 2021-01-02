package com.weblaptop.backend.models.DTO;

import java.util.List;

public class CartDto {
    private long id;
    private long totalPrice;
    private List<CartDetailDto> cartDetailDtos;

    public CartDto() {
    }
    public CartDto(long id, long totalPrice, List<CartDetailDto> cartDetailDtos) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.cartDetailDtos = cartDetailDtos;
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

    public List<CartDetailDto> getCartDetailDtos() {
        return cartDetailDtos;
    }

    public void setCartDetailDtos(List<CartDetailDto> cartDetailDtos) {
        this.cartDetailDtos = cartDetailDtos;
    }
}
