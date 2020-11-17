package com.weblaptop.backend.models.DTO;

import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Image;

import java.util.Date;

public class LaptopDTO {
    private long id;
    private String manufacturer;
    private String category;
    private String modelCode;
    private String name;
    private Date year;
    private Image arrImage;
    private String status;
    private long amount;
    private long price;

    private String cpu;
    private String ram;
    private String screen;
    private String graphicCard;
    private String storage;
    private String battery;
    private String port;
    private String weight;
    private String OS;

    public LaptopDTO() {
    }

    public LaptopDTO(long id, String idManufacturer, String idCategory, String modelCode, String name, Date year,
                     Image idImage, String status, long amount, long price, String cpu, String ram, String screen,
                     String graphicCard, String storage, String battery, String port, String weight, String OS) {
            this.id = id;
        this.manufacturer = idManufacturer;
        this.category = idCategory;
        this.modelCode = modelCode;
        this.name = name;

        this.year = year;
        this.arrImage = idImage;
        this.status = status;
        this.amount = amount;
        this.price = price;
        this.cpu = cpu;
        this.ram = ram;
        this.screen = screen;
        this.graphicCard = graphicCard;
        this.storage = storage;
        this.battery = battery;
        this.port = port;
        this.weight = weight;
        this.OS = OS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdManufacturer() {
        return manufacturer;
    }

    public void setIdManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIdCategory() {
        return category;
    }

    public void setIdCategory(String idCategory) {
        this.category = idCategory;
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

    public Image getIdImage() {
        return arrImage;
    }

    public void setIdImage(Image idImage) {
        this.arrImage = idImage;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
}
