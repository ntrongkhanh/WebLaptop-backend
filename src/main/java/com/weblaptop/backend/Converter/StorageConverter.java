package com.weblaptop.backend.Converter;

import com.weblaptop.backend.models.DTO.StorageDTO;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import com.weblaptop.backend.models.ENTITY.Product.Storage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StorageConverter {
    public Storage toStorageEntity(StorageDTO dto){
        Storage storage=new Storage();
        storage.setCapacity(dto.getCapacity());
        storage.setConnectionProtocol(dto.getConnectionProtocol());
        storage.setReadSpeed(dto.getReadSpeed());
        storage.setWriteSpeed(dto.getWriteSpeed());
        return storage;
    }
    public Product toProductEntity(StorageDTO dto){
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
    public StorageDTO toDTO(Product product){
        StorageDTO dto=new StorageDTO();
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

        dto.setCapacity(product.getStorage().getCapacity());
        dto.setConnectionProtocol(product.getStorage().getConnectionProtocol());
        dto.setReadSpeed(product.getStorage().getReadSpeed());
        dto.setWriteSpeed(product.getStorage().getWriteSpeed());
        return dto;
    }
    public List<StorageDTO> toDTOs(List<Product> products){
        List<StorageDTO> dtos=new ArrayList<>();
        for (Product product:products){
            dtos.add(this.toDTO(product));
        }
        return dtos;
    }
}
