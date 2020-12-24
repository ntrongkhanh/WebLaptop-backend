package com.weblaptop.backend.Converter;


import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.models.ENTITY.Product.LaptopEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LaptopConverter {
    public ProductEntity toProductEntity(LaptopDTO dto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setYear(dto.getYear());
        productEntity.setWeight(dto.getWeight());
        productEntity.setStatus(dto.getStatus());

        // productEntity.setProductType(dto.getProductType());
        productEntity.setPrice(dto.getPrice());
        productEntity.setName(dto.getName());
        productEntity.setModelCode(dto.getModelCode());
        //   productEntity.setManufacturer(dto.getManufacturer());
        //   productEntity.setImage(dto.getImage());
        productEntity.setId(dto.getId());
        productEntity.setGuarantee(dto.getGuarantee());
        productEntity.setDescription(dto.getDescription());
        productEntity.setAmount(dto.getAmount());
        productEntity.setColor(dto.getColor());
        return productEntity;
    }
    public LaptopEntity toLaptopEntity(LaptopDTO dto){
        LaptopEntity laptopEntity =new LaptopEntity();
        laptopEntity.setStorage(dto.getStorage());
        laptopEntity.setScreen(dto.getScreen());
        laptopEntity.setRam(dto.getRam());
        laptopEntity.setPort(dto.getPort());
        laptopEntity.setOS(dto.getOS());
        laptopEntity.setId(dto.getId());
        laptopEntity.setGraphicCard(dto.getGraphicCard());
        laptopEntity.setCpu(dto.getCpu());
        laptopEntity.setBattery(dto.getBattery());
        laptopEntity.setStorage(dto.getStorage());
        return laptopEntity;
    }
    public LaptopDTO toProductDTO(ProductEntity productEntity){
        LaptopDTO dto=new LaptopDTO();
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
        dto.setColor(productEntity.getColor());

        dto.setOS(productEntity.getLaptopEntity().getOS());
        dto.setWeight(productEntity.getWeight());
        dto.setPort(productEntity.getLaptopEntity().getPort());
        dto.setBattery(productEntity.getLaptopEntity().getBattery());
        dto.setModelCode(productEntity.getModelCode());
        dto.setNational(productEntity.getManufacturerEntity().getNational());
        dto.setStatus(productEntity.getStatus());
        dto.setPrice(productEntity.getPrice());
        dto.setAmount(productEntity.getAmount());
        dto.setScreen(productEntity.getLaptopEntity().getScreen());
        dto.setGraphicCard(productEntity.getLaptopEntity().getGraphicCard());
        dto.setName(productEntity.getName());
        dto.setStorage(productEntity.getLaptopEntity().getStorage());
        dto.setRam(productEntity.getLaptopEntity().getRam());
        dto.setYear(productEntity.getYear());
        dto.setCpu(productEntity.getLaptopEntity().getCpu());
        dto.setId(productEntity.getId());
        return dto;
    }
    public List<LaptopDTO> toDTOs(List<ProductEntity> productEntities){
        List<LaptopDTO> dtos=new ArrayList<>();
        for (ProductEntity productEntity : productEntities){
            dtos.add(this.toProductDTO(productEntity));
        }
        return dtos;
    }
}
