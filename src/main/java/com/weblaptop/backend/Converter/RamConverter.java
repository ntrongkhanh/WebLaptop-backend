package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.RamDTO;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import com.weblaptop.backend.models.ENTITY.Product.Ram;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RamConverter {
    public Ram toRamEntity(RamDTO dto){
        Ram ram=new Ram();
        ram.setVoltage(dto.getVoltage());
        ram.setCapacity(dto.getCapacity());
        ram.setBuss(dto.getBuss());
        return ram;
    }
    public Product toProductEntity(RamDTO dto){
        Product product=new Product();
        product.setYear(dto.getYear());
        product.setWeight(dto.getWeight());
        product.setStatus(dto.getStatus());
        product.setPrice(dto.getPrice());
        product.setName(dto.getName());
        product.setModelCode(dto.getModelCode());
        product.setId(dto.getId());
        product.setGuarantee(dto.getGuarantee());
        product.setDescription(dto.getDescription());
        product.setAmount(dto.getAmount());
        product.setColor(dto.getColor());
        return product;
    }
    public RamDTO toDTO(Product product){
        RamDTO dto=new RamDTO();
        dto.setProductType(product.getProductType().getName());
        dto.setImage(product.getImage().getImage());
        dto.setIdProductType(product.getProductType().getId());
        dto.setGuarantee(product.getGuarantee());
        dto.setDescription(product.getDescription());
        dto.setIdImage(product.getImage().getId());
        dto.setCategory(product.getCategory().getName());
        dto.setIdCategory(product.getCategory().getId());
        dto.setIdManufacturer(product.getManufacturer().getId());
        dto.setManufacturer(product.getManufacturer().getName());
        dto.setWeight(product.getWeight());
        dto.setModelCode(product.getModelCode());
        dto.setNational(product.getManufacturer().getNational());
        dto.setStatus(product.getStatus());
        dto.setPrice(product.getPrice());
        dto.setAmount(product.getAmount());
        dto.setName(product.getName());
        dto.setYear(product.getYear());
        dto.setId(product.getId());
        dto.setColor(product.getColor());

        dto.setCapacity(product.getRam().getCapacity());
        dto.setBuss(product.getRam().getBuss());
        dto.setVoltage(product.getRam().getVoltage());
        return dto;
    }
    public List<RamDTO> toDTOs(List<Product> products){
        List<RamDTO> dtos=new ArrayList<>();
        for (Product product:products){
            dtos.add(this.toDTO(product));
        }
        return dtos;
    }
}
