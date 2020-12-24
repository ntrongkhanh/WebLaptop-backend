package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.MouseConverter;
import com.weblaptop.backend.models.DTO.MouseDTO;
import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import com.weblaptop.backend.models.ENTITY.Product.MouseEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.CategoryRepo;
import com.weblaptop.backend.repositories.ImageRepo;
import com.weblaptop.backend.repositories.ManufacturerRepo;
import com.weblaptop.backend.repositories.Product.MouseRepo;
import com.weblaptop.backend.repositories.Product.ProductRepo;
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
public class MouseService {
    @Autowired
    private MouseConverter MouseConverter;
    @Autowired
    private MouseRepo MouseRepo;
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
    public ResponseEntity<Map<String, Object>> create(MouseDTO dto) {
        try {

            ProductEntity productEntity =MouseConverter.toProductEntity(dto);
            CategoryEntity categoryEntity =entityManager.getReference(CategoryEntity.class,dto.getIdCategory());
            productEntity.setCategoryEntity(categoryEntity);
            ImageEntity imageEntity =new ImageEntity();
            imageEntity.setImage(dto.getImage());
            imageEntity =imageRepo.saveAndFlush(imageEntity);
            productEntity.setImageEntity(imageEntity);
            ManufacturerEntity manufacturerEntity =entityManager.getReference(ManufacturerEntity.class,dto.getIdManufacturer());
            productEntity.setManufacturerEntity(manufacturerEntity);
            ProductTypeEntity productTypeEntity = productTypeRepo.getByName("MOUSE");
            productEntity.setProductTypeEntity(productTypeEntity);
            productEntity = productRepo.saveAndFlush(productEntity);
            MouseEntity MouseEntity = MouseConverter.toMouseEntity(dto);

            ProductEntity productEntity1 =entityManager.getReference(ProductEntity.class, productEntity.getId());
            MouseEntity.setProduct(productEntity1);
            MouseEntity = MouseRepo.save(MouseEntity);


            Map<String, Object> response = new HashMap<>();
            response.put("ProductEntity", productEntity);
            response.put("MouseEntity", MouseEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Map<String, Object>> update(MouseDTO dto) {
        Optional<ProductEntity> productOptional = productRepo.findById(dto.getId());
        if (!productOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        MouseEntity mouseEntity = MouseRepo.findById(productOptional.get().getMouseEntity().getId()).get();
        mouseEntity = MouseConverter.toMouseEntity(dto);
        ProductEntity productEntity =entityManager.getReference(ProductEntity.class,dto.getId());
        mouseEntity.setProduct(productEntity);
        mouseEntity.setId(productEntity.getMouseEntity().getId());
        mouseEntity = MouseRepo.saveAndFlush(mouseEntity);


        productEntity = MouseConverter.toProductEntity(dto);
        CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
        productEntity.setCategoryEntity(categoryEntity);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(dto.getImage());
        imageEntity = imageRepo.saveAndFlush(imageEntity);
        productEntity.setImageEntity(imageEntity);
        ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
        productEntity.setManufacturerEntity(manufacturerEntity);
        ProductTypeEntity productTypeEntity = productTypeRepo.getByName("MOUSE");
        productEntity.setProductTypeEntity(productTypeEntity);
        productEntity = productRepo.save(productEntity);

        Map<String, Object> response = new HashMap<>();
        response.put("ProductEntity", productEntity);
        response.put("MouseEntity", mouseEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<MouseDTO> dtos = MouseConverter.toDTOs(productRepo.findAllMouse());
            Map<String, Object> response = new HashMap<>();
            response.put("MouseEntity", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>>  delete(long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<ProductEntity> product = productRepo.findById(id);
        if (!product.isPresent()){
            response.put("data","delete failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ProductEntity productEntity1 =entityManager.getReference(ProductEntity.class,id);

        try {
            MouseRepo.deleteById(productEntity1.getMouseEntity().getId());
            productRepo.deleteById(id);
            response.put("data","delete success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("data","delete failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }


    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<ProductEntity> product = productRepo.findById(id);
            if (!product.isPresent()){
                Map<String, Object> response = new HashMap<>();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            //  LaptopEntity dto = product.get().getLaptop();
            MouseDTO dto=new MouseDTO();
            dto.setId(product.get().getId());
            dto=MouseConverter.toDTO(product.get());
//            dto.setIdManufacturer(product.get().getManufacturer().getId());
//            dto.setManufacturer(product.get().getManufacturer().getName());
//            dto.setIdCategory(product.get().getCategory().getId());
//            dto.setCategory(product.get().getCategory().getName());
//            dto.setIdProductType(product.get().getProductType().getId());
//            dto.setProductType(product.get().getProductType().getName());
//            dto.setIdImage(product.get().getImage().getId());
//            dto.setImage(product.get().getImage().getImage());
//            dto.setModelCode(product.get().getModelCode());
//            dto.setName(product.get().getName());
//            dto.setYear(product.get().getYear());
//            dto.setStatus(product.get().getStatus());
//            dto.setAmount(product.get().getAmount());
//            dto.setPrice(product.get().getPrice());
//            dto.setNational(product.get().getManufacturer().getNational());
//            dto.setWeight(product.get().getWeight());
//            dto.setGuarantee(product.get().getGuarantee());
//            dto.setDescription(product.get().getDescription());
//            dto.setColor(product.get().getColor());
//
//            dto.setStandardConnection(product.get().getMouse().getStandardConnection());
//            dto.setConnectionProtocol(product.get().getMouse().getConnectionProtocol());
//            dto.setSensorEye(product.get().getMouse().getSensorEye());
//            dto.setDpi(product.get().getMouse().getDpi());
//            dto.setLed(product.get().getMouse().getLed());
//            dto.setButton(product.get().getMouse().getButton());
//            dto.setSize(product.get().getMouse().getSize());
//            dto.setBattery(product.get().getMouse().getBattery());
//            dto.setOs(product.get().getMouse().getOs());


            Map<String, Object> response = new HashMap<>();
            response.put("MouseEntity", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
