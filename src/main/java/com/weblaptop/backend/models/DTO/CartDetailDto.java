package com.weblaptop.backend.models.DTO;

public class CartDetailDto {
    private long id;
    private long idProduct;
    private int amount;
    private String image;
    private String name;
    private long price;
    private long totalPrice;

    public CartDetailDto() {
    }

    public CartDetailDto(long idProduct, int amount) {
        this.idProduct = idProduct;
        this.amount = amount;
    }

    public CartDetailDto(long id, long idProduct, int amount, String image, String name, long price) {
        this.id = id;
        this.idProduct = idProduct;
        this.amount = amount;
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public CartDetailDto(long id, int amount, String image, String name, long price) {
        this.id = id;
        this.amount = amount;
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public CartDetailDto(long id, long idProduct, int amount, String image, String name, long price, long totalPrice) {
        this.id = id;
        this.idProduct = idProduct;
        this.amount = amount;
        this.image = image;
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
