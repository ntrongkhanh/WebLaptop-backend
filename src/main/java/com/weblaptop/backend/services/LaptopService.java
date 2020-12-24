package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.LaptopConverter;
import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import com.weblaptop.backend.models.ENTITY.Product.LaptopEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.CategoryRepository;
import com.weblaptop.backend.repositories.ImageRepository;
import com.weblaptop.backend.repositories.Product.LaptopRepository;
import com.weblaptop.backend.repositories.Product.ProductRepository;
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
public class LaptopService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private LaptopRepository laptopRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LaptopConverter converter;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private EntityManager entityManager;

    public ResponseEntity<Map<String, Object>> create(LaptopDTO dto) {
        try {
            ProductEntity productEntity = converter.toProductEntity(dto);
            CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
            productEntity.setCategoryEntity(categoryEntity);
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImage(dto.getImage());
            imageEntity = imageRepository.saveAndFlush(imageEntity);
            productEntity.setImageEntity(imageEntity);
            ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
            productEntity.setManufacturerEntity(manufacturerEntity);
            ProductTypeEntity productTypeEntity = productTypeRepository.getByName("LAPTOP");
            productEntity.setProductTypeEntity(productTypeEntity);
            productEntity = productRepository.saveAndFlush(productEntity);

            LaptopEntity laptopEntity = converter.toLaptopEntity(dto);


            ProductEntity productEntity1 = entityManager.getReference(ProductEntity.class, productEntity.getId());
            laptopEntity.setProduct(productEntity1);
            laptopEntity = laptopRepository.save(laptopEntity);


            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> update(LaptopDTO dto) {
        try {
            Optional<ProductEntity> productOptional = productRepository.findById(dto.getId());
            if (!productOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            LaptopEntity laptopEntity = laptopRepository.findById(productOptional.get().getLaptopEntity().getId()).get();
            laptopEntity = converter.toLaptopEntity(dto);
            ProductEntity productEntity = entityManager.getReference(ProductEntity.class, dto.getId());
            laptopEntity.setProduct(productEntity);
            laptopEntity.setId(productEntity.getLaptopEntity().getId());
            laptopEntity = laptopRepository.saveAndFlush(laptopEntity);


            productEntity = converter.toProductEntity(dto);
            CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
            productEntity.setCategoryEntity(categoryEntity);
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImage(dto.getImage());
            imageEntity = imageRepository.saveAndFlush(imageEntity);
            productEntity.setImageEntity(imageEntity);
            ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
            productEntity.setManufacturerEntity(manufacturerEntity);
            ProductTypeEntity productTypeEntity = productTypeRepository.getByName("LAPTOP");
            productEntity.setProductTypeEntity(productTypeEntity);
            productEntity = productRepository.save(productEntity);

            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<LaptopDTO> laptopDTOS = converter.toDTOs(productRepository.findAllLaptop());
            Map<String, Object> response = new HashMap<>();
            response.put("data", laptopDTOS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> delete(long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        Map<String, Object> response = new HashMap<>();
        if (!product.isPresent()) {
            response.put("data","Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ProductEntity productEntity1 = entityManager.getReference(ProductEntity.class, id);
        try {
            laptopRepository.deleteById(productEntity1.getLaptopEntity().getId());
            productRepository.deleteById(id);
            response.put("data","Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
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
            response.put("data", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
