package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.KeyboardDTO;
import com.weblaptop.backend.models.ENTITY.Product.Keyboard;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KeyboardConverter {
    public Keyboard toKeyboardEntity(KeyboardDTO dto){
        Keyboard keyboard=new Keyboard();
        keyboard.setStandardConnection(dto.getStandardConnection());
        keyboard.setSize(dto.getSize());
        keyboard.setLed(dto.getLed());
        keyboard.setConnectionProtocol(dto.getConnectionProtocol());
        keyboard.set_switch(dto.get_switch());
        return keyboard;
    }
    public Product toProductEntity(KeyboardDTO dto){
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
        return product;
    }
    public KeyboardDTO toKeyboardDTO(Product product){
        KeyboardDTO dto=new KeyboardDTO();
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

        dto.setSize(product.getKeyboard().getSize());
        dto.setStandardConnection(product.getKeyboard().getStandardConnection());
        dto.setConnectionProtocol(product.getKeyboard().getConnectionProtocol());
        dto.setLed(product.getKeyboard().getLed());
        dto.set_switch(product.getKeyboard().get_switch());
        return dto;
    }
    public List<KeyboardDTO> toDTOs(List<Product> products){
        List<KeyboardDTO> dtos=new ArrayList<>();
        for (Product product:products){
            dtos.add(this.toKeyboardDTO(product));
        }
        return dtos;
    }
}
