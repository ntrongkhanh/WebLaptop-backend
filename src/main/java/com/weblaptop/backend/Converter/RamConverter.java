package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.RamDTO;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.Product.RamEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RamConverter {
    public RamEntity toRamEntity(RamDTO dto){
        RamEntity ramEntity =new RamEntity();
        ramEntity.setVoltage(dto.getVoltage());
        ramEntity.setCapacity(dto.getCapacity());
        ramEntity.setBuss(dto.getBuss());
        return ramEntity;
    }
    public ProductEntity toProductEntity(RamDTO dto){
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
    public RamDTO toDTO(ProductEntity productEntity){
        RamDTO dto=new RamDTO();
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

        dto.setCapacity(productEntity.getRamEntity().getCapacity());
        dto.setBuss(productEntity.getRamEntity().getBuss());
        dto.setVoltage(productEntity.getRamEntity().getVoltage());
        return dto;
    }
    public List<RamDTO> toDTOs(List<ProductEntity> productEntities){
        List<RamDTO> dtos=new ArrayList<>();
        for (ProductEntity productEntity : productEntities){
            dtos.add(this.toDTO(productEntity));
        }
        return dtos;
    }
}
