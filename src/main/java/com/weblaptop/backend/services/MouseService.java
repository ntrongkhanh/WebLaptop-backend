package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.MouseConverter;
import com.weblaptop.backend.models.DTO.MouseDTO;
import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import com.weblaptop.backend.models.ENTITY.Product.MouseEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import com.weblaptop.backend.repositories.CategoryRepository;
import com.weblaptop.backend.repositories.ImageRepository;
import com.weblaptop.backend.repositories.ManufacturerRepository;
import com.weblaptop.backend.repositories.Product.MouseRepository;
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
public class MouseService {
    @Autowired
    private MouseConverter MouseConverter;
    @Autowired
    private MouseRepository MouseRepository;
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
    public ResponseEntity<Map<String, Object>> create(MouseDTO dto) {
        try {

            ProductEntity productEntity =MouseConverter.toProductEntity(dto);
            CategoryEntity categoryEntity =entityManager.getReference(CategoryEntity.class,dto.getIdCategory());
            productEntity.setCategoryEntity(categoryEntity);
            ImageEntity imageEntity =new ImageEntity();
            imageEntity.setImage(dto.getImage());
            imageEntity = imageRepository.saveAndFlush(imageEntity);
            productEntity.setImageEntity(imageEntity);
            ManufacturerEntity manufacturerEntity =entityManager.getReference(ManufacturerEntity.class,dto.getIdManufacturer());
            productEntity.setManufacturerEntity(manufacturerEntity);
            ProductTypeEntity productTypeEntity = productTypeRepository.getByName("MOUSE");
            productEntity.setProductTypeEntity(productTypeEntity);
            productEntity = productRepository.saveAndFlush(productEntity);
            MouseEntity MouseEntity = MouseConverter.toMouseEntity(dto);

            ProductEntity productEntity1 =entityManager.getReference(ProductEntity.class, productEntity.getId());
            MouseEntity.setProduct(productEntity1);
            MouseEntity = MouseRepository.save(MouseEntity);


            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Map<String, Object>> update(MouseDTO dto) {
        Optional<ProductEntity> productOptional = productRepository.findById(dto.getId());
        if (!productOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        MouseEntity mouseEntity = MouseRepository.findById(productOptional.get().getMouseEntity().getId()).get();
        mouseEntity = MouseConverter.toMouseEntity(dto);
        ProductEntity productEntity =entityManager.getReference(ProductEntity.class,dto.getId());
        mouseEntity.setProduct(productEntity);
        mouseEntity.setId(productEntity.getMouseEntity().getId());
        mouseEntity = MouseRepository.saveAndFlush(mouseEntity);


        productEntity = MouseConverter.toProductEntity(dto);
        CategoryEntity categoryEntity = entityManager.getReference(CategoryEntity.class, dto.getIdCategory());
        productEntity.setCategoryEntity(categoryEntity);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(dto.getImage());
        imageEntity = imageRepository.saveAndFlush(imageEntity);
        productEntity.setImageEntity(imageEntity);
        ManufacturerEntity manufacturerEntity = entityManager.getReference(ManufacturerEntity.class, dto.getIdManufacturer());
        productEntity.setManufacturerEntity(manufacturerEntity);
        ProductTypeEntity productTypeEntity = productTypeRepository.getByName("MOUSE");
        productEntity.setProductTypeEntity(productTypeEntity);
        productEntity = productRepository.save(productEntity);

        Map<String, Object> response = new HashMap<>();
        response.put("data", "Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<MouseDTO> dtos = MouseConverter.toDTOs(productRepository.findAllMouse());
            Map<String, Object> response = new HashMap<>();
            response.put("data", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>>  delete(long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<ProductEntity> product = productRepository.findById(id);
        if (!product.isPresent()){
            response.put("data","Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ProductEntity productEntity1 =entityManager.getReference(ProductEntity.class,id);

        try {
            MouseRepository.deleteById(productEntity1.getMouseEntity().getId());
            productRepository.deleteById(id);
            response.put("data","Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("data","Failed");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }


    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<ProductEntity> product = productRepository.findById(id);
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
