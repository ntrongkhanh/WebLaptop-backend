package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.RamConverter;
import com.weblaptop.backend.models.DTO.CategoryDTO;
import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.models.DTO.RamDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Image;
import com.weblaptop.backend.models.ENTITY.Manufacturer;
import com.weblaptop.backend.models.ENTITY.Product.Laptop;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import com.weblaptop.backend.models.ENTITY.Product.Ram;
import com.weblaptop.backend.models.ENTITY.ProductType;
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

            Product product=ramConverter.toProductEntity(dto);
            Category category=entityManager.getReference(Category.class,dto.getIdCategory());
            product.setCategory(category);
            Image image=new Image();
            image.setImage(dto.getImage());
            image=imageRepo.saveAndFlush(image);
            product.setImage(image);
            Manufacturer manufacturer=entityManager.getReference(Manufacturer.class,dto.getIdManufacturer());
            product.setManufacturer(manufacturer);
            ProductType productType = productTypeRepo.getByName("RAM");
            product.setProductType(productType);
            product = productRepo.saveAndFlush(product);
            Ram ram = ramConverter.toRamEntity(dto);

            Product product1=entityManager.getReference(Product.class,product.getId());
            ram.setProduct(product1);
            ram = ramRepo.save(ram);


            Map<String, Object> response = new HashMap<>();
            response.put("Product", product);
            response.put("Ram", ram);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<RamDTO> dtos = ramConverter.toDTOs( productRepo.findAllRam());
            Map<String, Object> response = new HashMap<>();
            response.put("Rams", dtos);
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
            RamDTO dto=new RamDTO();
            dto.setYear(product.get().getYear());
            dto.setWeight(product.get().getWeight());
            dto.setVoltage(product.get().getRam().getVoltage());
            dto.setStatus(product.get().getStatus());
            dto.setProductType(product.get().getProductType().getName());
            dto.setPrice(product.get().getPrice());
            dto.setNational(product.get().getManufacturer().getNational());
            dto.setName(product.get().getName());
            dto.setModelCode(product.get().getModelCode());
            dto.setManufacturer(product.get().getManufacturer().getName());
            dto.setImage(product.get().getImage().getImage());
            dto.setIdProductType(product.get().getProductType().getId());
            dto.setIdManufacturer(product.get().getManufacturer().getId());
            dto.setIdImage(product.get().getImage().getId());
            dto.setIdCategory(product.get().getCategory().getId());
            dto.setGuarantee(product.get().getGuarantee());
            dto.setDescription(product.get().getDescription());
            dto.setCategory(product.get().getCategory().getName());
            dto.setCapacity(product.get().getRam().getCapacity());
            dto.setBuss(product.get().getRam().getBuss());
            dto.setAmount(product.get().getAmount());

            Map<String, Object> response = new HashMap<>();
            response.put("Ram", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
