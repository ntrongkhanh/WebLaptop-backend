package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.KeyboardDTO;
import com.weblaptop.backend.models.DTO.MouseDTO;
import com.weblaptop.backend.models.ENTITY.Product.Mouse;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MouseConverter {
    public Mouse toMouseEntity(MouseDTO dto){
        Mouse mouse=new Mouse();
        mouse.setStandardConnection(dto.getStandardConnection());
        mouse.setSize(dto.getSize());
        mouse.setSensorEye(dto.getSensorEye());
        mouse.setOs(dto.getOs());
        mouse.setLed(dto.getLed());
        mouse.setDpi(dto.getDpi());
        mouse.setConnectionProtocol(dto.getConnectionProtocol());

        mouse.setButton(dto.getButton());
        mouse.setBattery(dto.getBattery());
        return mouse;
    }
    public Product toProductEntity(MouseDTO dto){
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
        product.setColor(product.getColor());
        return product;
    }
    public MouseDTO toDTO(Product product){
        MouseDTO dto=new MouseDTO();
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

        dto.setStandardConnection(product.getMouse().getStandardConnection());
        dto.setConnectionProtocol(product.getMouse().getConnectionProtocol());
        dto.setSensorEye(product.getMouse().getSensorEye());
        dto.setDpi(product.getMouse().getDpi());
        dto.setLed(product.getMouse().getLed());
        dto.setButton(product.getMouse().getButton());
        dto.setSize(product.getMouse().getSize());
        dto.setBattery(product.getMouse().getBattery());
        dto.setOs(product.getMouse().getOs());
        dto.setColor(product.getColor());

        return dto;
    }
    public List<MouseDTO> toDTOs(List<Product> products){
        List<MouseDTO> dtos=new ArrayList<>();
        for (Product product:products){
            dtos.add(this.toDTO(product));
        }
        return dtos;
    }
}
