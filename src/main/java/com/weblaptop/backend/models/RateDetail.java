package com.weblaptop.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RateDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idRate;
    private int star;
    private String content;
    private Date time;

    public RateDetail() {
    }

    public RateDetail(long id, long idRate, int star, String content, Date time) {
        this.id = id;
        this.idRate = idRate;
        this.star = star;
        this.content = content;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdRate() {
        return idRate;
    }

    public void setIdRate(long idRate) {
        this.idRate = idRate;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
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
