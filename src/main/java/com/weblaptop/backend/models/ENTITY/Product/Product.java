package com.weblaptop.backend.models.ENTITY.Product;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Image;
import com.weblaptop.backend.models.ENTITY.Manufacturer;
import com.weblaptop.backend.models.ENTITY.ProductType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idManufacturer", nullable = false)
    private Manufacturer manufacturer;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProductType", nullable = false)
    private ProductType productType;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCategory", nullable = true)
    private Category category;
    private String name;
    private String modelCode;
    private Date year;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idImage", nullable = false)
    private Image image;
    private String status;
    private String weight;
    private long amount;
    private long price;
    private String guarantee;
    private String description;

    @OneToOne(mappedBy = "product")
    private Ram ram;
    @OneToOne(mappedBy = "product")
    private Storage storage;
    @OneToOne(mappedBy = "product")
    private Keyboard keyboard;
    @OneToOne(mappedBy = "product")
    private Mouse mouse;
    @OneToOne(mappedBy = "product")
    private Laptop laptop;

    public Product() {
    }

    public Product(long id, Manufacturer manufacturer, ProductType productType, Category category, String name,
                   String modelCode, Date year, Image image, String status, String weight, long amount,
                   long price, String guarantee, String description, Ram ram, Storage storage, Laptop laptop,
                   Keyboard keyboard, Mouse mouse) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.productType = productType;
        this.category = category;
        this.name = name;
        this.modelCode = modelCode;
        this.year = year;
        this.image = image;
        this.status = status;
        this.weight = weight;
        this.amount = amount;
        this.price = price;
        this.guarantee = guarantee;
        this.description = description;
        this.ram = ram;
        this.storage = storage;
        this.laptop = laptop;
        this.keyboard = keyboard;
        this.mouse = mouse;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
