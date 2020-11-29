package com.weblaptop.backend.Converter;


import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.models.ENTITY.Product.Laptop;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LaptopConverter {
    public Product toProductEntity(LaptopDTO dto) {
        Product product = new Product();
        product.setYear(dto.getYear());
        product.setWeight(dto.getWeight());
        product.setStatus(dto.getStatus());

        // product.setProductType(dto.getProductType());
        product.setPrice(dto.getPrice());
        product.setName(dto.getName());
        product.setModelCode(dto.getModelCode());
        //   product.setManufacturer(dto.getManufacturer());
        //   product.setImage(dto.getImage());
        product.setId(dto.getId());
        product.setGuarantee(dto.getGuarantee());
        product.setDescription(dto.getDescription());
        product.setAmount(dto.getAmount());
        return product;
    }
    public Laptop toLaptopEntity(LaptopDTO dto){
        Laptop laptop=new Laptop();
        laptop.setStorage(dto.getStorage());
        laptop.setScreen(dto.getScreen());
        laptop.setRam(dto.getRam());
        laptop.setPort(dto.getPort());
        laptop.setOS(dto.getOS());
        laptop.setId(dto.getId());
        laptop.setGraphicCard(dto.getGraphicCard());
        laptop.setCpu(dto.getCpu());
        laptop.setBattery(dto.getBattery());
        laptop.setStorage(dto.getStorage());
        return laptop;
    }
    public LaptopDTO toProductDTO(Product product){
        LaptopDTO dto=new LaptopDTO();
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

        dto.setOS(product.getLaptop().getOS());
        dto.setWeight(product.getWeight());
        dto.setPort(product.getLaptop().getPort());
        dto.setBattery(product.getLaptop().getBattery());
        dto.setModelCode(product.getModelCode());
        dto.setNational(product.getManufacturer().getNational());
        dto.setStatus(product.getStatus());
        dto.setPrice(product.getPrice());
        dto.setAmount(product.getAmount());
        dto.setScreen(product.getLaptop().getScreen());
        dto.setGraphicCard(product.getLaptop().getGraphicCard());
        dto.setName(product.getName());
        dto.setStorage(product.getLaptop().getStorage());
        dto.setRam(product.getLaptop().getRam());
        dto.setYear(product.getYear());
        dto.setCpu(product.getLaptop().getCpu());
        dto.setId(product.getId());
        return dto;
    }
    public List<LaptopDTO> toDTOs(List<Product> products){
        List<LaptopDTO> dtos=new ArrayList<>();
        for (Product product: products){
            dtos.add(this.toProductDTO(product));
        }
        return dtos;
    }
}
