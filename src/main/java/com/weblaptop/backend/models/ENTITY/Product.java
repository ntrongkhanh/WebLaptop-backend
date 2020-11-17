package com.weblaptop.backend.models.ENTITY;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idManufacturer", nullable = false)
    private Manufacturer manufacturer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCategory", nullable = false)
    private Category category;
    private String modelCode;
    private String name;
    private boolean isLaptop;
    private Date year;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idImage", nullable = false)
    private Image arrImage;
    private String status;
    private long amount;
    private long price;

    @OneToMany(mappedBy = "product")
    private List<RateDetail> rateDetails;
    @OneToMany(mappedBy = "accessories")
    private List<AccessoriesDetail> accessoriesDetails;

    public Product() {
    }

    public Product(long id, Manufacturer manufacturer, Category category, String modelCode, String name,
                   boolean isLaptop, Date year, Image arrImage, String status, long amount,
                   long price, List<RateDetail> rateDetails, List<AccessoriesDetail> accessoriesDetails) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.category = category;
        this.modelCode = modelCode;
        this.name = name;
        this.isLaptop = isLaptop;
        this.year = year;
        this.arrImage = arrImage;
        this.status = status;
        this.amount = amount;
        this.price = price;
        this.rateDetails = rateDetails;
        this.accessoriesDetails = accessoriesDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLaptop() {
        return isLaptop;
    }

    public void setLaptop(boolean laptop) {
        isLaptop = laptop;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Image getArrImage() {
        return arrImage;
    }

    public void setArrImage(Image arrImage) {
        this.arrImage = arrImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<RateDetail> getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(List<RateDetail> rateDetails) {
        this.rateDetails = rateDetails;
    }

    public List<AccessoriesDetail> getAccessoriesDetails() {
        return accessoriesDetails;
    }

    public void setAccessoriesDetails(List<AccessoriesDetail> accessoriesDetails) {
        this.accessoriesDetails = accessoriesDetails;
    }
}
