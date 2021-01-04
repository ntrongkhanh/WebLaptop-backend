package com.weblaptop.backend.models.DTO;

import com.weblaptop.backend.models.ENTITY.User;

import java.util.Date;
import java.util.List;

public class CommentDto {
    private long id;
    private long idProduct;
    private String content;
    private Date time;
    private User user;

    public CommentDto(long id, long idProduct, String content, Date time, User user) {
        this.id = id;
        this.idProduct = idProduct;
        this.content = content;
        this.time = time;
        this.user = user;
    }

    public CommentDto() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
