package com.weblaptop.backend.models.ENTITY.Product;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.weblaptop.backend.models.ENTITY.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ProductEntity")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idManufacturer", nullable = true)
    private ManufacturerEntity manufacturerEntity;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idProductType", nullable = true)
    private ProductTypeEntity productTypeEntity;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idCategory", nullable = true)
    private CategoryEntity categoryEntity;
    private String name;
    private String modelCode;
    private Date year;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idImage", nullable = true)
    private ImageEntity imageEntity;
    private String status;
    private String weight;
    private long amount;
    private long price;
    private String guarantee;
    private String description;
    private String color;

    @OneToOne(mappedBy = "product")
    private RamEntity ramEntity;
    @OneToOne(mappedBy = "product")
    private StorageEntity storageEntity;
    @OneToOne(mappedBy = "product")
    private KeyboardEntity keyboardEntity;
    @OneToOne(mappedBy = "product")
    private MouseEntity mouseEntity;
    @OneToOne(mappedBy = "product")
    private LaptopEntity laptopEntity;
    @OneToMany(mappedBy = "productEntity")
    private List<CartDetailEntity> cartDetailEntities;

    public ProductEntity() {
    }

    public ProductEntity(long id, ManufacturerEntity manufacturerEntity, ProductTypeEntity productTypeEntity,
                         CategoryEntity categoryEntity, String name, String modelCode, Date year,
                         ImageEntity imageEntity, String status, String weight, long amount, long price,
                         String guarantee, String description, String color, RamEntity ramEntity,
                         StorageEntity storageEntity, KeyboardEntity keyboardEntity, MouseEntity mouseEntity,
                         LaptopEntity laptopEntity, List<CartDetailEntity> cartDetailEntities) {
        this.id = id;
        this.manufacturerEntity = manufacturerEntity;
        this.productTypeEntity = productTypeEntity;
        this.categoryEntity = categoryEntity;
        this.name = name;
        this.modelCode = modelCode;
        this.year = year;
        this.imageEntity = imageEntity;
        this.status = status;
        this.weight = weight;
        this.amount = amount;
        this.price = price;
        this.guarantee = guarantee;
        this.description = description;
        this.color = color;
        this.ramEntity = ramEntity;
        this.storageEntity = storageEntity;
        this.keyboardEntity = keyboardEntity;
        this.mouseEntity = mouseEntity;
        this.laptopEntity = laptopEntity;
        this.cartDetailEntities = cartDetailEntities;
    }

    public ProductEntity(long id, ManufacturerEntity manufacturerEntity, ProductTypeEntity productTypeEntity, CategoryEntity categoryEntity, String name,
                         String modelCode, Date year, ImageEntity imageEntity, String status, String weight, long amount, long price,
                         String guarantee, String description, String color, RamEntity ramEntity, StorageEntity storageEntity, KeyboardEntity keyboardEntity,
                         MouseEntity mouseEntity, LaptopEntity laptopEntity) {
        this.id = id;
        this.manufacturerEntity = manufacturerEntity;
        this.productTypeEntity = productTypeEntity;
        this.categoryEntity = categoryEntity;
        this.name = name;
        this.modelCode = modelCode;
        this.year = year;
        this.imageEntity = imageEntity;
        this.status = status;
        this.weight = weight;
        this.amount = amount;
        this.price = price;
        this.guarantee = guarantee;
        this.description = description;
        this.color = color;
        this.ramEntity = ramEntity;
        this.storageEntity = storageEntity;
        this.keyboardEntity = keyboardEntity;
        this.mouseEntity = mouseEntity;
        this.laptopEntity = laptopEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ManufacturerEntity getManufacturerEntity() {
        return manufacturerEntity;
    }

    public void setManufacturerEntity(ManufacturerEntity manufacturerEntity) {
        this.manufacturerEntity = manufacturerEntity;
    }

    public ProductTypeEntity getProductTypeEntity() {
        return productTypeEntity;
    }

    public void setProductTypeEntity(ProductTypeEntity productTypeEntity) {
        this.productTypeEntity = productTypeEntity;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
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

    public ImageEntity getImageEntity() {
        return imageEntity;
    }

    public void setImageEntity(ImageEntity imageEntity) {
        this.imageEntity = imageEntity;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public RamEntity getRamEntity() {
        return ramEntity;
    }

    public void setRamEntity(RamEntity ramEntity) {
        this.ramEntity = ramEntity;
    }

    public StorageEntity getStorageEntity() {
        return storageEntity;
    }

    public void setStorageEntity(StorageEntity storageEntity) {
        this.storageEntity = storageEntity;
    }

    public KeyboardEntity getKeyboardEntity() {
        return keyboardEntity;
    }

    public void setKeyboardEntity(KeyboardEntity keyboardEntity) {
        this.keyboardEntity = keyboardEntity;
    }

    public MouseEntity getMouseEntity() {
        return mouseEntity;
    }

    public void setMouseEntity(MouseEntity mouseEntity) {
        this.mouseEntity = mouseEntity;
    }

    public LaptopEntity getLaptopEntity() {
        return laptopEntity;
    }

    public void setLaptopEntity(LaptopEntity laptopEntity) {
        this.laptopEntity = laptopEntity;
    }

    public List<CartDetailEntity> getCartDetailEntities() {
        return cartDetailEntities;
    }

    public void setCartDetailEntities(List<CartDetailEntity> cartDetailEntities) {
        this.cartDetailEntities = cartDetailEntities;
    }
}
