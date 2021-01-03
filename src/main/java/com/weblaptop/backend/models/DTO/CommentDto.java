package com.weblaptop.backend.models.DTO;

import com.weblaptop.backend.models.ENTITY.User;

import java.util.Date;
import java.util.List;

public class CommentDto {
    private long id;
    private long idProduct;
    private String content;
    private Date time;
    private List<CommentDto> children;
    private long idParent;
    private User user;

    public CommentDto(long id, long idProduct, String content, Date time, List<CommentDto> children, long idParent, User user) {
        this.id = id;
        this.idProduct = idProduct;
        this.content = content;
        this.time = time;
        this.children = children;
        this.idParent = idParent;
        this.user = user;
    }

    public CommentDto(long id, long idProduct, String content, Date time, List<CommentDto> children, User user) {
        this.id = id;
        this.idProduct = idProduct;
        this.content = content;
        this.time = time;
        this.children = children;
        this.user = user;
    }

    public long getIdParent() {
        return idParent;
    }

    public void setIdParent(long idParent) {
        this.idParent = idParent;
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

    public List<CommentDto> getChildren() {
        return children;
    }

    public void setChildren(List<CommentDto> children) {
        this.children = children;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
