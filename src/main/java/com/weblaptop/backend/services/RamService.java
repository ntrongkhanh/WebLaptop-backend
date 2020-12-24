package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.RamConverter;
import com.weblaptop.backend.models.DTO.RamDTO;
import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.Product.RamEntity;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.CategoryRepo;
import com.weblaptop.backend.repositories.ImageRepo;
import com.weblaptop.backend.repositories.Product.ProductRepo;
import com.weblaptop.backend.repositories.Product.RamRepo;
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
public class RamService {
    @Autowired
    private RamConverter ramConverter;
    @Autowired
    private RamRepo ramRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ImageRepo imageRepo;
    @Autowired
    private ProductTypeRepo productTypeRepo;

    public ResponseEntity<Map<String, Object>> create(RamDTO dto) {
        try {

            ProductEntity productEntity = ramConverter.toProductEntity(dto);
            CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
            productEntity.setCategoryEntity(categoryEntity);
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImage(dto.getImage());
            imageEntity = imageRepo.saveAndFlush(imageEntity);
            productEntity.setImageEntity(imageEntity);
            ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
            productEntity.setManufacturerEntity(manufacturerEntity);
            ProductTypeEntity productTypeEntity = productTypeRepo.getByName("RAM");
            productEntity.setProductTypeEntity(productTypeEntity);
            productEntity = productRepo.saveAndFlush(productEntity);
            RamEntity ramEntity = ramConverter.toRamEntity(dto);

            ProductEntity productEntity1 = entityManager.getReference(ProductEntity.class, productEntity.getId());
            ramEntity.setProduct(productEntity1);
            ramEntity = ramRepo.save(ramEntity);


            Map<String, Object> response = new HashMap<>();
            response.put("ProductEntity", productEntity);
            response.put("RamEntity", imageEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> update(RamDTO dto) {
        Optional<ProductEntity> productOptional = productRepo.findById(dto.getId());
        if (!productOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        RamEntity ramEntity = ramRepo.findById(productOptional.get().getRamEntity().getId()).get();
        ramEntity = ramConverter.toRamEntity(dto);
        ProductEntity productEntity = entityManager.getReference(ProductEntity.class, dto.getId());
        ramEntity.setProduct(productEntity);
        ramEntity.setId(productEntity.getRamEntity().getId());
        ramEntity = ramRepo.saveAndFlush(ramEntity);


        productEntity = ramConverter.toProductEntity(dto);
        CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
        productEntity.setCategoryEntity(categoryEntity);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(dto.getImage());
        imageEntity = imageRepo.saveAndFlush(imageEntity);
        productEntity.setImageEntity(imageEntity);
        ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
        productEntity.setManufacturerEntity(manufacturerEntity);
        ProductTypeEntity productTypeEntity = productTypeRepo.getByName("RAM");
        productEntity.setProductTypeEntity(productTypeEntity);
        productEntity = productRepo.save(productEntity);

        Map<String, Object> response = new HashMap<>();
        response.put("ProductEntity", productEntity);
        response.put("RamEntity", ramEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<RamDTO> dtos = ramConverter.toDTOs(productRepo.findAllRam());
            Map<String, Object> response = new HashMap<>();
            response.put("Rams", dtos);
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
            ramRepo.deleteById(productEntity1.getRamEntity().getId());
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
            RamDTO dto = new RamDTO();
            dto=ramConverter.toDTO(product.get());
//            dto.setYear(product.get().getYear());
//            dto.setWeight(product.get().getWeight());
//            dto.setVoltage(product.get().getRam().getVoltage());
//            dto.setStatus(product.get().getStatus());
//            dto.setProductType(product.get().getProductType().getName());
//            dto.setPrice(product.get().getPrice());
//            dto.setNational(product.get().getManufacturer().getNational());
//            dto.setName(product.get().getName());
//            dto.setModelCode(product.get().getModelCode());
//            dto.setManufacturer(product.get().getManufacturer().getName());
//            dto.setImage(product.get().getImage().getImage());
//            dto.setIdProductType(product.get().getProductType().getId());
//            dto.setIdManufacturer(product.get().getManufacturer().getId());
//            dto.setIdImage(product.get().getImage().getId());
//            dto.setIdCategory(product.get().getCategory().getId());
//            dto.setGuarantee(product.get().getGuarantee());
//            dto.setDescription(product.get().getDescription());
//            dto.setCategory(product.get().getCategory().getName());
//            dto.setCapacity(product.get().getRam().getCapacity());
//            dto.setBuss(product.get().getRam().getBuss());
//            dto.setAmount(product.get().getAmount());
//            dto.setId(product.get().getId());
//            dto.setColor(product.get().getColor());
            Map<String, Object> response = new HashMap<>();
            response.put("RamEntity", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
