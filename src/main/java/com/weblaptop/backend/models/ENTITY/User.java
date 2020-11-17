package com.weblaptop.backend.models.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String password;
    private String name;
    private String sex;
    @OneToMany(mappedBy = "user")
    private List<RateDetail> rateDetails;
    @OneToOne(fetch = FetchType.LAZY,  optional = false)
    private RateDetail rateDetail;
    @OneToOne(fetch = FetchType.LAZY,  optional = false)
    private Comment comment;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idContact", nullable = false)
    private Contact contact;

    public User() {
    }

    public User(long id, String email, String password, String name, String sex, List<RateDetail> rateDetails,
                RateDetail rateDetail, Comment comment, Contact contact) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.rateDetails = rateDetails;
        this.rateDetail = rateDetail;
        this.comment = comment;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<RateDetail> getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(List<RateDetail> rateDetails) {
        this.rateDetails = rateDetails;
    }

    public RateDetail getRateDetail() {
        return rateDetail;
    }

    public void setRateDetail(RateDetail rateDetail) {
        this.rateDetail = rateDetail;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
