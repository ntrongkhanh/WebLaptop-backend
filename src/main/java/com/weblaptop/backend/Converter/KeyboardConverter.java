package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.KeyboardDTO;
import com.weblaptop.backend.models.ENTITY.Product.KeyboardEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KeyboardConverter {
    public KeyboardEntity toKeyboardEntity(KeyboardDTO dto){
        KeyboardEntity keyboardEntity =new KeyboardEntity();
        keyboardEntity.setStandardConnection(dto.getStandardConnection());
        keyboardEntity.setSize(dto.getSize());
        keyboardEntity.setLed(dto.getLed());
        keyboardEntity.setConnectionProtocol(dto.getConnectionProtocol());
        keyboardEntity.set_switch(dto.get_switch());

        return keyboardEntity;
    }
    public ProductEntity toProductEntity(KeyboardDTO dto){
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
    public KeyboardDTO toKeyboardDTO(ProductEntity productEntity){
        KeyboardDTO dto=new KeyboardDTO();
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

        dto.setSize(productEntity.getKeyboardEntity().getSize());
        dto.setStandardConnection(productEntity.getKeyboardEntity().getStandardConnection());
        dto.setConnectionProtocol(productEntity.getKeyboardEntity().getConnectionProtocol());
        dto.setLed(productEntity.getKeyboardEntity().getLed());
        dto.set_switch(productEntity.getKeyboardEntity().get_switch());
        return dto;
    }
    public List<KeyboardDTO> toDTOs(List<ProductEntity> productEntities){
        List<KeyboardDTO> dtos=new ArrayList<>();
        for (ProductEntity productEntity : productEntities){
            dtos.add(this.toKeyboardDTO(productEntity));
        }
        return dtos;
    }
}
