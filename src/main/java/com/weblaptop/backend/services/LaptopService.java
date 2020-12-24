package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.LaptopConverter;
import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import com.weblaptop.backend.models.ENTITY.Product.LaptopEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.CategoryRepo;
import com.weblaptop.backend.repositories.ImageRepo;
import com.weblaptop.backend.repositories.Product.LaptopRepo;
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
public class LaptopService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private LaptopRepo laptopRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private LaptopConverter converter;
    @Autowired
    private ProductTypeRepo productTypeRepo;
    @Autowired
    private ImageRepo imageRepo;
    @Autowired
    private EntityManager entityManager;

    public ResponseEntity<Map<String, Object>> create(LaptopDTO dto) {
        try {
            ProductEntity productEntity = converter.toProductEntity(dto);
            CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
            productEntity.setCategoryEntity(categoryEntity);
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImage(dto.getImage());
            imageEntity = imageRepo.saveAndFlush(imageEntity);
            productEntity.setImageEntity(imageEntity);
            ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
            productEntity.setManufacturerEntity(manufacturerEntity);
            ProductTypeEntity productTypeEntity = productTypeRepo.getByName("LAPTOP");
            productEntity.setProductTypeEntity(productTypeEntity);
            productEntity = productRepo.saveAndFlush(productEntity);

            LaptopEntity laptopEntity = converter.toLaptopEntity(dto);


            ProductEntity productEntity1 = entityManager.getReference(ProductEntity.class, productEntity.getId());
            laptopEntity.setProduct(productEntity1);
            laptopEntity = laptopRepo.save(laptopEntity);


            Map<String, Object> response = new HashMap<>();
            response.put("ProductEntity", productEntity);
            response.put("LaptopEntity", laptopEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> update(LaptopDTO dto) {
        Optional<ProductEntity> productOptional = productRepo.findById(dto.getId());
        if (!productOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        LaptopEntity laptopEntity = laptopRepo.findById(productOptional.get().getLaptopEntity().getId()).get();
        laptopEntity = converter.toLaptopEntity(dto);
        ProductEntity productEntity = entityManager.getReference(ProductEntity.class, dto.getId());
        laptopEntity.setProduct(productEntity);
        laptopEntity.setId(productEntity.getLaptopEntity().getId());
        laptopEntity = laptopRepo.saveAndFlush(laptopEntity);


        productEntity = converter.toProductEntity(dto);
        CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
        productEntity.setCategoryEntity(categoryEntity);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(dto.getImage());
        imageEntity = imageRepo.saveAndFlush(imageEntity);
        productEntity.setImageEntity(imageEntity);
        ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
        productEntity.setManufacturerEntity(manufacturerEntity);
        ProductTypeEntity productTypeEntity = productTypeRepo.getByName("LAPTOP");
        productEntity.setProductTypeEntity(productTypeEntity);
        productEntity = productRepo.save(productEntity);

        Map<String, Object> response = new HashMap<>();
        response.put("ProductEntity", productEntity);
        response.put("RamEntity", laptopEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<LaptopDTO> laptopDTOS = converter.toDTOs(productRepo.findAllLaptop());
            Map<String, Object> response = new HashMap<>();
            response.put("LaptopEntity", laptopDTOS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> delete(long id) {
        Optional<ProductEntity> product = productRepo.findById(id);
        Map<String, Object> response = new HashMap<>();
        if (!product.isPresent()) {
            response.put("data","delete failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ProductEntity productEntity1 = entityManager.getReference(ProductEntity.class, id);
        try {
            laptopRepo.deleteById(productEntity1.getLaptopEntity().getId());
            productRepo.deleteById(id);
            response.put("data","delete success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
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
            LaptopDTO dto = new LaptopDTO();
            dto=converter.toProductDTO(product.get());
//            dto.setProductType(product.get().getProductType().getName());
//            dto.setImage(product.get().getImage().getImage());
//            dto.setIdProductType(product.get().getProductType().getId());
//            dto.setGuarantee(product.get().getGuarantee());
//            dto.setDescription(product.get().getDescription());
//            dto.setIdImage(product.get().getImage().getId());
//            dto.setCategory(product.get().getCategory().getName());
//            dto.setIdCategory(product.get().getCategory().getId());
//            dto.setIdManufacturer(product.get().getManufacturer().getId());
//            dto.setManufacturer(product.get().getManufacturer().getName());
//            dto.setOS(product.get().getLaptop().getOS());
//            dto.setWeight(product.get().getWeight());
//            dto.setPort(product.get().getLaptop().getPort());
//            dto.setBattery(product.get().getLaptop().getBattery());
//            dto.setModelCode(product.get().getModelCode());
//            dto.setNational(product.get().getManufacturer().getNational());
//            dto.setStatus(product.get().getStatus());
//            dto.setPrice(product.get().getPrice());
//            dto.setAmount(product.get().getAmount());
//            dto.setScreen(product.get().getLaptop().getScreen());
//            dto.setGraphicCard(product.get().getLaptop().getGraphicCard());
//            dto.setName(product.get().getName());
//            dto.setStorage(product.get().getLaptop().getStorage());
//            dto.setRam(product.get().getLaptop().getRam());
//            dto.setYear(product.get().getYear());
//            dto.setCpu(product.get().getLaptop().getCpu());
//            dto.setId(product.get().getId());
//            dto.setColor(product.get().getColor());
            Map<String, Object> response = new HashMap<>();
            response.put("LaptopEntity", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
