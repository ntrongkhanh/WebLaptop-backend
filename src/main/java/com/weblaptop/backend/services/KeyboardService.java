package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.KeyboardConverter;
import com.weblaptop.backend.models.DTO.KeyboardDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Image;
import com.weblaptop.backend.models.ENTITY.Manufacturer;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import com.weblaptop.backend.models.ENTITY.Product.Keyboard;
import com.weblaptop.backend.models.ENTITY.ProductType;
import com.weblaptop.backend.repositories.CategoryRepo;
import com.weblaptop.backend.repositories.ImageRepo;
import com.weblaptop.backend.repositories.ManufacturerRepo;
import com.weblaptop.backend.repositories.Product.ProductRepo;
import com.weblaptop.backend.repositories.Product.KeyboardRepo;
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
public class KeyboardService {
    @Autowired
    private KeyboardConverter KeyboardConverter;
    @Autowired
    private KeyboardRepo KeyboardRepo;
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
    public ResponseEntity<Map<String, Object>> create(KeyboardDTO dto) {
        try {

            Product product=KeyboardConverter.toProductEntity(dto);
            Category category=entityManager.getReference(Category.class,dto.getIdCategory());
            product.setCategory(category);
            Image image=new Image();
            image.setImage(dto.getImage());
            image=imageRepo.saveAndFlush(image);
            product.setImage(image);
            Manufacturer manufacturer=entityManager.getReference(Manufacturer.class,dto.getIdManufacturer());
            product.setManufacturer(manufacturer);
            ProductType productType = productTypeRepo.getByName("KEYBOARD");
            product.setProductType(productType);
            product = productRepo.saveAndFlush(product);
            Keyboard Keyboard = KeyboardConverter.toKeyboardEntity(dto);

            Product product1=entityManager.getReference(Product.class,product.getId());
            Keyboard.setProduct(product1);
            Keyboard = KeyboardRepo.save(Keyboard);


            Map<String, Object> response = new HashMap<>();
            response.put("Product", product);
            response.put("Keyboard", Keyboard);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<KeyboardDTO> dtos = KeyboardConverter.toDTOs(productRepo.findAllKeyboard());
            Map<String, Object> response = new HashMap<>();
            response.put("Keyboard", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delete(long id) {
        productRepo.deleteById(id);
    }


    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<Product> product = productRepo.findById(id);

            //  Laptop dto = product.get().getLaptop();
            KeyboardDTO dto=new KeyboardDTO();
            dto.setId(product.get().getRam().getId());
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

            dto.setSize(product.get().getKeyboard().getSize());
            dto.setStandardConnection(product.get().getKeyboard().getStandardConnection());
            dto.setConnectionProtocol(product.get().getKeyboard().getConnectionProtocol());
            dto.setLed(product.get().getKeyboard().getLed());
            dto.set_switch(product.get().getKeyboard().get_switch());

            Map<String, Object> response = new HashMap<>();
            response.put("Storage", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
