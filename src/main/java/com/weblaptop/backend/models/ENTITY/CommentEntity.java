package com.weblaptop.backend.models.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProduct", nullable = false)
    private ProductEntity productEntity;
    @Column(name = "image",  columnDefinition="TEXT")
    private String content;
    private Date time;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private CommentEntity parent;
    @OneToMany(mappedBy="parent")
    private List<CommentEntity> children;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    public CommentEntity() {
    }

    public CommentEntity(long id, ProductEntity productEntity, String content, Date time, CommentEntity parent, List<CommentEntity> children, User user) {
        this.id = id;
        this.productEntity = productEntity;
        this.content = content;
        this.time = time;
        this.parent = parent;
        this.children = children;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
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

    public CommentEntity getParent() {
        return parent;
    }

    public void setParent(CommentEntity parent) {
        this.parent = parent;
    }

    public List<CommentEntity> getChildren() {
        return children;
    }

    public void setChildren(List<CommentEntity> children) {
        this.children = children;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
