package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.StorageConverter;
import com.weblaptop.backend.models.DTO.RamDTO;
import com.weblaptop.backend.models.DTO.StorageDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Image;
import com.weblaptop.backend.models.ENTITY.Manufacturer;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import com.weblaptop.backend.models.ENTITY.Product.Ram;
import com.weblaptop.backend.models.ENTITY.Product.Storage;
import com.weblaptop.backend.models.ENTITY.ProductType;
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

            Product product = storageConverter.toProductEntity(dto);
            Category category = entityManager.getReference(Category.class, dto.getIdCategory());
            product.setCategory(category);
            Image image = new Image();
            image.setImage(dto.getImage());
            image = imageRepo.saveAndFlush(image);
            product.setImage(image);
            Manufacturer manufacturer = entityManager.getReference(Manufacturer.class, dto.getIdManufacturer());
            product.setManufacturer(manufacturer);
            ProductType productType = productTypeRepo.getByName("STORAGE");
            product.setProductType(productType);
            product = productRepo.saveAndFlush(product);
            Storage storage = storageConverter.toStorageEntity(dto);

            Product product1 = entityManager.getReference(Product.class, product.getId());
            storage.setProduct(product1);
            storage = storageRepo.save(storage);


            Map<String, Object> response = new HashMap<>();
            response.put("Product", product);
            response.put("Storage", storage);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> update(StorageDTO dto) {
        Optional<Product> productOptional = productRepo.findById(dto.getId());
        if (!productOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        Storage storage = storageRepo.findById(productOptional.get().getStorage().getId()).get();
        storage = storageConverter.toStorageEntity(dto);
        Product product = entityManager.getReference(Product.class, dto.getId());
        storage.setProduct(product);
        storage.setId(product.getStorage().getId());
        storage = storageRepo.saveAndFlush(storage);


        product = storageConverter.toProductEntity(dto);
        Category category = entityManager.getReference(Category.class, dto.getIdCategory());
        product.setCategory(category);
        Image image = new Image();
        image.setImage(dto.getImage());
        image = imageRepo.saveAndFlush(image);
        product.setImage(image);
        Manufacturer manufacturer = entityManager.getReference(Manufacturer.class, dto.getIdManufacturer());
        product.setManufacturer(manufacturer);
        ProductType productType = productTypeRepo.getByName("STORAGE");
        product.setProductType(productType);
        product = productRepo.save(product);

        Map<String, Object> response = new HashMap<>();
        response.put("Product", product);
        response.put("Ram", storage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<StorageDTO> dtos = storageConverter.toDTOs(productRepo.findAllStorage());
            Map<String, Object> response = new HashMap<>();
            response.put("Storage", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delete(long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent())
            return;
        Product product1 = entityManager.getReference(Product.class, id);
        try {
            storageRepo.deleteById(product1.getStorage().getId());
            productRepo.deleteById(id);
        } catch (Exception e) {
            return;
        }

    }


    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<Product> product = productRepo.findById(id);
            if (!product.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            //  Laptop dto = product.get().getLaptop();
            StorageDTO dto = new StorageDTO();
            dto.setId(product.get().getId());
            dto.setIdManufacturer(product.get().getManufacturer().getId());
            dto.setManufacturer(product.get().getManufacturer().getName());
            dto.setIdCategory(product.get().getCategory().getId());
            dto.setCategory(product.get().getCategory().getName());
            dto.setIdProductType(product.get().getProductType().getId());
            dto.setProductType(product.get().getProductType().getName());
            dto.setIdImage(product.get().getImage().getId());
            dto.setImage(product.get().getImage().getImage());
            dto.setModelCode(product.get().getModelCode());
            dto.setName(product.get().getName());
            dto.setYear(product.get().getYear());
            dto.setStatus(product.get().getStatus());
            dto.setAmount(product.get().getAmount());
            dto.setPrice(product.get().getPrice());
            dto.setNational(product.get().getManufacturer().getNational());
            dto.setWeight(product.get().getWeight());
            dto.setGuarantee(product.get().getGuarantee());
            dto.setDescription(product.get().getDescription());
            dto.setColor(product.get().getColor());

            dto.setCapacity(product.get().getStorage().getCapacity());
            dto.setConnectionProtocol(product.get().getStorage().getConnectionProtocol());
            dto.setReadSpeed(product.get().getStorage().getReadSpeed());
            dto.setWriteSpeed(product.get().getStorage().getWriteSpeed());

            Map<String, Object> response = new HashMap<>();
            response.put("Storage", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
