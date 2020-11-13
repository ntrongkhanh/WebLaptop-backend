package com.weblaptop.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String password;
    private String name;
    private String sex;

    public User() {
    }

    public User(long id, String email, String password, String name, String sex) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
