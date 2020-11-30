package com.weblaptop.backend.models.DTO;

import java.util.Date;

public class LaptopDTO {
    private long id;
    private long idManufacturer;
    private String manufacturer;
    private long idCategory;
    private String category;
    private long idProductType;
    private String productType;
    private long idImage;
    private String image;
    private String modelCode;
    private String name;
    private Date year;
    private String status;
    private long amount;
    private long price;
    private String national;
    private String weight;
    private String guarantee;
    private String description;
    private String color;

    private String cpu;
    private String ram;
    private String screen;
    private String graphicCard;
    private String storage;
    private String battery;
    private String port;
    private String OS;

    public LaptopDTO() {
    }

    public LaptopDTO(long id, long idManufacturer, String manufacturer, long idCategory, String category,
                     long idProductType, String productType, long idImage, String image, String modelCode,
                     String name, Date year, String status, long amount, long price, String national,
                     String weight, String guarantee, String description, String cpu, String ram, String screen,
                     String graphicCard, String storage,String color, String battery, String port, String OS) {
        this.id = id;
        this.idManufacturer = idManufacturer;
        this.manufacturer = manufacturer;
        this.idCategory = idCategory;
        this.category = category;
        this.idProductType = idProductType;
        this.productType = productType;
        this.idImage = idImage;
        this.image = image;
        this.modelCode = modelCode;
        this.name = name;
        this.year = year;
        this.status = status;
        this.amount = amount;
        this.price = price;
        this.national = national;
        this.weight = weight;
        this.guarantee = guarantee;
        this.description = description;
        this.cpu = cpu;
        this.ram = ram;
        this.screen = screen;
        this.graphicCard = graphicCard;
        this.storage = storage;
        this.battery = battery;
        this.port = port;
        this.OS = OS;
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(long idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(long idProductType) {
        this.idProductType = idProductType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public long getIdImage() {
        return idImage;
    }

    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
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

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
}
