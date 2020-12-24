package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.StorageConverter;
import com.weblaptop.backend.models.DTO.StorageDTO;
import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.Product.StorageEntity;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.CategoryRepo;
import com.weblaptop.backend.repositories.ImageRepo;
import com.weblaptop.backend.repositories.ManufacturerRepo;
import com.weblaptop.backend.repositories.Product.ProductRepo;
import com.weblaptop.backend.repositories.Product.StorageRepo;
import com.weblaptop.backend.repositories.ProductTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageConverter storageConverter;
    @Autowired
    private StorageRepo storageRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductTypeRepo productTypeRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ManufacturerRepo manufacturerRepo;
    @Autowired
    private ImageRepo imageRepo;

    public ResponseEntity<Map<String, Object>> create(StorageDTO dto) {
        try {

            ProductEntity productEntity = storageConverter.toProductEntity(dto);
            CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
            productEntity.setCategoryEntity(categoryEntity);
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImage(dto.getImage());
            imageEntity = imageRepo.saveAndFlush(imageEntity);
            productEntity.setImageEntity(imageEntity);
            ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
            productEntity.setManufacturerEntity(manufacturerEntity);
            ProductTypeEntity productTypeEntity = productTypeRepo.getByName("STORAGE");
            productEntity.setProductTypeEntity(productTypeEntity);
            productEntity = productRepo.saveAndFlush(productEntity);
            StorageEntity storageEntity = storageConverter.toStorageEntity(dto);

            ProductEntity productEntity1 = entityManager.getReference(ProductEntity.class, productEntity.getId());
            storageEntity.setProduct(productEntity1);
            storageEntity = storageRepo.save(storageEntity);


            Map<String, Object> response = new HashMap<>();
            response.put("ProductEntity", productEntity);
            response.put("StorageEntity", storageEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> update(StorageDTO dto) {
        Optional<ProductEntity> productOptional = productRepo.findById(dto.getId());
        if (!productOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        StorageEntity storageEntity = storageRepo.findById(productOptional.get().getStorageEntity().getId()).get();
        storageEntity = storageConverter.toStorageEntity(dto);
        ProductEntity productEntity = entityManager.getReference(ProductEntity.class, dto.getId());
        storageEntity.setProduct(productEntity);
        storageEntity.setId(productEntity.getStorageEntity().getId());
        storageEntity = storageRepo.saveAndFlush(storageEntity);


        productEntity = storageConverter.toProductEntity(dto);
        CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
        productEntity.setCategoryEntity(categoryEntity);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(dto.getImage());
        imageEntity = imageRepo.saveAndFlush(imageEntity);
        productEntity.setImageEntity(imageEntity);
        ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
        productEntity.setManufacturerEntity(manufacturerEntity);
        ProductTypeEntity productTypeEntity = productTypeRepo.getByName("STORAGE");
        productEntity.setProductTypeEntity(productTypeEntity);
        productEntity = productRepo.save(productEntity);

        Map<String, Object> response = new HashMap<>();
        response.put("ProductEntity", productEntity);
        response.put("RamEntity", storageEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<StorageDTO> dtos = storageConverter.toDTOs(productRepo.findAllStorage());
            Map<String, Object> response = new HashMap<>();
            response.put("StorageEntity", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> delete(long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<ProductEntity> product = productRepo.findById(id);
        if (!product.isPresent()) {
            response.put("data", "delete failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ProductEntity productEntity1 = entityManager.getReference(ProductEntity.class, id);
        try {
            storageRepo.deleteById(productEntity1.getStorageEntity().getId());
            productRepo.deleteById(id);
            response.put("data", "delete success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("data", "delete failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<ProductEntity> product = productRepo.findById(id);
            if (!product.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            //  LaptopEntity dto = product.get().getLaptop();
            StorageDTO dto = new StorageDTO();
            dto=storageConverter.toDTO(product.get());
//            dto.setId(product.get().getId());
//            dto.setIdManufacturer(product.get().getManufacturerEntity().getId());
//            dto.setManufacturer(product.get().getManufacturerEntity().getName());
//            dto.setIdCategory(product.get().getCategoryEntity().getId());
//            dto.setCategory(product.get().getCategoryEntity().getName());
//            dto.setIdProductType(product.get().getProductTypeEntity().getId());
//            dto.setProductType(product.get().getProductTypeEntity().getName());
//            dto.setIdImage(product.get().getImageEntity().getId());
//            dto.setImage(product.get().getImageEntity().getImage());
//            dto.setModelCode(product.get().getModelCode());
//            dto.setName(product.get().getName());
//            dto.setYear(product.get().getYear());
//            dto.setStatus(product.get().getStatus());
//            dto.setAmount(product.get().getAmount());
//            dto.setPrice(product.get().getPrice());
//            dto.setNational(product.get().getManufacturerEntity().getNational());
//            dto.setWeight(product.get().getWeight());
//            dto.setGuarantee(product.get().getGuarantee());
//            dto.setDescription(product.get().getDescription());
//            dto.setColor(product.get().getColor());
//
//            dto.setCapacity(product.get().getStorageEntity().getCapacity());
//            dto.setConnectionProtocol(product.get().getStorageEntity().getConnectionProtocol());
//            dto.setReadSpeed(product.get().getStorageEntity().getReadSpeed());
//            dto.setWriteSpeed(product.get().getStorageEntity().getWriteSpeed());

            Map<String, Object> response = new HashMap<>();
            response.put("StorageEntity", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
