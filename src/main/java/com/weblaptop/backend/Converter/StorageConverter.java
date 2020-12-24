package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.StorageDTO;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.Product.StorageEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StorageConverter {
    public StorageEntity toStorageEntity(StorageDTO dto){
        StorageEntity storageEntity =new StorageEntity();
        storageEntity.setCapacity(dto.getCapacity());
        storageEntity.setConnectionProtocol(dto.getConnectionProtocol());
        storageEntity.setReadSpeed(dto.getReadSpeed());
        storageEntity.setWriteSpeed(dto.getWriteSpeed());
        return storageEntity;
    }
    public ProductEntity toProductEntity(StorageDTO dto){
        ProductEntity productEntity =new ProductEntity();
        productEntity.setYear(dto.getYear());
        productEntity.setWeight(dto.getWeight());
        productEntity.setStatus(dto.getStatus());
        productEntity.setPrice(dto.getPrice());
        productEntity.setName(dto.getName());
        productEntity.setModelCode(dto.getModelCode());
        productEntity.setId(dto.getId());
        productEntity.setGuarantee(dto.getGuarantee());
        productEntity.setDescription(dto.getDescription());
        productEntity.setAmount(dto.getAmount());
        productEntity.setColor(dto.getColor());
        return productEntity;
    }
    public StorageDTO toDTO(ProductEntity productEntity){
        StorageDTO dto=new StorageDTO();
        dto.setProductType(productEntity.getProductTypeEntity().getName());
        dto.setImage(productEntity.getImageEntity().getImage());
        dto.setIdProductType(productEntity.getProductTypeEntity().getId());
        dto.setGuarantee(productEntity.getGuarantee());
        dto.setDescription(productEntity.getDescription());
        dto.setIdImage(productEntity.getImageEntity().getId());
        dto.setCategory(productEntity.getCategoryEntity().getName());
        dto.setIdCategory(productEntity.getCategoryEntity().getId());
        dto.setIdManufacturer(productEntity.getManufacturerEntity().getId());
        dto.setManufacturer(productEntity.getManufacturerEntity().getName());
        dto.setWeight(productEntity.getWeight());
        dto.setModelCode(productEntity.getModelCode());
        dto.setNational(productEntity.getManufacturerEntity().getNational());
        dto.setStatus(productEntity.getStatus());
        dto.setPrice(productEntity.getPrice());
        dto.setAmount(productEntity.getAmount());
        dto.setName(productEntity.getName());
        dto.setYear(productEntity.getYear());
        dto.setId(productEntity.getId());
        dto.setColor(productEntity.getColor());

        dto.setCapacity(productEntity.getStorageEntity().getCapacity());
        dto.setConnectionProtocol(productEntity.getStorageEntity().getConnectionProtocol());
        dto.setReadSpeed(productEntity.getStorageEntity().getReadSpeed());
        dto.setWriteSpeed(productEntity.getStorageEntity().getWriteSpeed());
        return dto;
    }
    public List<StorageDTO> toDTOs(List<ProductEntity> productEntities){
        List<StorageDTO> dtos=new ArrayList<>();
        for (ProductEntity productEntity : productEntities){
            dtos.add(this.toDTO(productEntity));
        }
        return dtos;
    }
}
