package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.KeyboardConverter;
import com.weblaptop.backend.models.DTO.KeyboardDTO;
import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import com.weblaptop.backend.models.ENTITY.Product.KeyboardEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.CategoryRepository;
import com.weblaptop.backend.repositories.ImageRepository;
import com.weblaptop.backend.repositories.ManufacturerRepository;
import com.weblaptop.backend.repositories.Product.ProductRepository;
import com.weblaptop.backend.repositories.Product.KeyboardRepository;
import com.weblaptop.backend.repositories.ProductTypeRepository;
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
public class KeyboardService {
    @Autowired
    private KeyboardConverter KeyboardConverter;
    @Autowired
    private KeyboardRepository KeyboardRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private ImageRepository imageRepository;

    public ResponseEntity<Map<String, Object>> create(KeyboardDTO dto) {
        try {

            ProductEntity productEntity = KeyboardConverter.toProductEntity(dto);
            CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
            productEntity.setCategoryEntity(categoryEntity);
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImage(dto.getImage());
            imageEntity = imageRepository.saveAndFlush(imageEntity);
            productEntity.setImageEntity(imageEntity);
            ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
            productEntity.setManufacturerEntity(manufacturerEntity);
            ProductTypeEntity productTypeEntity = productTypeRepository.getByName("KEYBOARD");
            productEntity.setProductTypeEntity(productTypeEntity);
            productEntity = productRepository.saveAndFlush(productEntity);
            KeyboardEntity KeyboardEntity = KeyboardConverter.toKeyboardEntity(dto);

            ProductEntity productEntity1 = entityManager.getReference(ProductEntity.class, productEntity.getId());
            KeyboardEntity.setProduct(productEntity1);
            KeyboardEntity = KeyboardRepository.save(KeyboardEntity);

            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> update(KeyboardDTO dto) {
        Optional<ProductEntity> productOptional = productRepository.findById(dto.getId());
        if (!productOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        KeyboardEntity keyboardEntity = KeyboardRepository.findById(productOptional.get().getKeyboardEntity().getId()).get();
        keyboardEntity = KeyboardConverter.toKeyboardEntity(dto);
        ProductEntity productEntity = entityManager.getReference(ProductEntity.class, dto.getId());
        keyboardEntity.setProduct(productEntity);
        keyboardEntity.setId(productEntity.getKeyboardEntity().getId());
        keyboardEntity = KeyboardRepository.saveAndFlush(keyboardEntity);


        productEntity = KeyboardConverter.toProductEntity(dto);
        CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
        productEntity.setCategoryEntity(categoryEntity);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(dto.getImage());
        imageEntity = imageRepository.saveAndFlush(imageEntity);
        productEntity.setImageEntity(imageEntity);
        ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
        productEntity.setManufacturerEntity(manufacturerEntity);
        ProductTypeEntity productTypeEntity = productTypeRepository.getByName("KEYBOARD");
        productEntity.setProductTypeEntity(productTypeEntity);
        productEntity = productRepository.save(productEntity);

        Map<String, Object> response = new HashMap<>();
        response.put("data", "Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<KeyboardDTO> dtos = KeyboardConverter.toDTOs(productRepository.findAllKeyboard());
            Map<String, Object> response = new HashMap<>();
            response.put("data", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Map<String, Object>> delete(long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<ProductEntity> product = productRepository.findById(id);
        if (!product.isPresent())
        {
            response.put("data","Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ProductEntity productEntity1 = entityManager.getReference(ProductEntity.class, id);
        try {
            KeyboardRepository.deleteById(productEntity1.getKeyboardEntity().getId());
            productRepository.deleteById(id);
            response.put("data","Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("data","Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<ProductEntity> product = productRepository.findById(id);
            if (!product.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            //  LaptopEntity dto = product.get().getLaptop();
            KeyboardDTO dto = new KeyboardDTO();
            dto.setId(product.get().getId());
            dto.setIdManufacturer(product.get().getManufacturerEntity().getId());
            dto.setManufacturer(product.get().getManufacturerEntity().getName());
            dto.setIdCategory(product.get().getCategoryEntity().getId());
            dto.setCategory(product.get().getCategoryEntity().getName());
            dto.setIdProductType(product.get().getProductTypeEntity().getId());
            dto.setProductType(product.get().getProductTypeEntity().getName());
            dto.setIdImage(product.get().getImageEntity().getId());
            dto.setImage(product.get().getImageEntity().getImage());
            dto.setModelCode(product.get().getModelCode());
            dto.setName(product.get().getName());
            dto.setYear(product.get().getYear());
            dto.setStatus(product.get().getStatus());
            dto.setAmount(product.get().getAmount());
            dto.setPrice(product.get().getPrice());
            dto.setNational(product.get().getManufacturerEntity().getNational());
            dto.setWeight(product.get().getWeight());
            dto.setGuarantee(product.get().getGuarantee());
            dto.setDescription(product.get().getDescription());
            dto.setColor(product.get().getColor());
            dto.setSize(product.get().getKeyboardEntity().getSize());
            dto.setStandardConnection(product.get().getKeyboardEntity().getStandardConnection());
            dto.setConnectionProtocol(product.get().getKeyboardEntity().getConnectionProtocol());
            dto.setLed(product.get().getKeyboardEntity().getLed());
            dto.set_switch(product.get().getKeyboardEntity().get_switch());

            Map<String, Object> response = new HashMap<>();
            response.put("data", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
