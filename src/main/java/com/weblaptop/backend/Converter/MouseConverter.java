package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.MouseDTO;
import com.weblaptop.backend.models.ENTITY.Product.MouseEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MouseConverter {
    public MouseEntity toMouseEntity(MouseDTO dto){
        MouseEntity mouseEntity =new MouseEntity();
        mouseEntity.setStandardConnection(dto.getStandardConnection());
        mouseEntity.setSize(dto.getSize());
        mouseEntity.setSensorEye(dto.getSensorEye());
        mouseEntity.setOs(dto.getOs());
        mouseEntity.setLed(dto.getLed());
        mouseEntity.setDpi(dto.getDpi());
        mouseEntity.setConnectionProtocol(dto.getConnectionProtocol());

        mouseEntity.setButton(dto.getButton());
        mouseEntity.setBattery(dto.getBattery());
        return mouseEntity;
    }
    public ProductEntity toProductEntity(MouseDTO dto){
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
        productEntity.setColor(productEntity.getColor());
        return productEntity;
    }
    public MouseDTO toDTO(ProductEntity productEntity){
        MouseDTO dto=new MouseDTO();
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

        dto.setStandardConnection(productEntity.getMouseEntity().getStandardConnection());
        dto.setConnectionProtocol(productEntity.getMouseEntity().getConnectionProtocol());
        dto.setSensorEye(productEntity.getMouseEntity().getSensorEye());
        dto.setDpi(productEntity.getMouseEntity().getDpi());
        dto.setLed(productEntity.getMouseEntity().getLed());
        dto.setButton(productEntity.getMouseEntity().getButton());
        dto.setSize(productEntity.getMouseEntity().getSize());
        dto.setBattery(productEntity.getMouseEntity().getBattery());
        dto.setOs(productEntity.getMouseEntity().getOs());
        dto.setColor(productEntity.getColor());

        return dto;
    }
    public List<MouseDTO> toDTOs(List<ProductEntity> productEntities){
        List<MouseDTO> dtos=new ArrayList<>();
        for (ProductEntity productEntity : productEntities){
            dtos.add(this.toDTO(productEntity));
        }
        return dtos;
    }
}
