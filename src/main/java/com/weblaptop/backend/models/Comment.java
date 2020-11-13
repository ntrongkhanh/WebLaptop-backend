package com.weblaptop.backend.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idProduct;
    private long idParents;
    private long idUser;
    private String content;
    private Date time;

    public Comment() {
    }

    public Comment(long id, long idProduct, long idParents, long idUser, String content, Date time) {
        this.id = id;
        this.idProduct = idProduct;
        this.idParents = idParents;
        this.idUser = idUser;
        this.content = content;
        this.time = time;
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

    public long getIdParents() {
        return idParents;
    }

    public void setIdParents(long idParents) {
        this.idParents = idParents;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
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
}
