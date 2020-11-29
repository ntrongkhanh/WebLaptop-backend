package com.weblaptop.backend.services;

import com.weblaptop.backend.Converter.LaptopConverter;
import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Image;
import com.weblaptop.backend.models.ENTITY.Manufacturer;
import com.weblaptop.backend.models.ENTITY.Product.Laptop;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import com.weblaptop.backend.models.ENTITY.ProductType;
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
            Product product = converter.toProductEntity(dto);
            Category category = entityManager.getReference(Category.class, dto.getIdCategory());
            product.setCategory(category);
            Image image = new Image();
            image.setImage(dto.getImage());
            image = imageRepo.saveAndFlush(image);
            product.setImage(image);
            Manufacturer manufacturer = entityManager.getReference(Manufacturer.class, dto.getIdManufacturer());
            product.setManufacturer(manufacturer);
            ProductType productType = productTypeRepo.getByName("LAPTOP");
            product.setProductType(productType);
            product = productRepo.saveAndFlush(product);

            Laptop laptop = converter.toLaptopEntity(dto);


            Product product1=entityManager.getReference(Product.class,product.getId());
            laptop.setProduct(product1);
            laptop = laptopRepo.save(laptop);


            Map<String, Object> response = new HashMap<>();
            response.put("Product", product);
            response.put("Laptop", laptop);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> getAll() {
        try {
            List<LaptopDTO> laptopDTOS = converter.toDTOs(productRepo.findAllLaptop());
            Map<String, Object> response = new HashMap<>();
            response.put("Laptop", laptopDTOS);
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
            LaptopDTO dto=new LaptopDTO();
            dto.setProductType(product.get().getProductType().getName());
            dto.setImage(product.get().getImage().getImage());
            dto.setIdProductType(product.get().getProductType().getId());
            dto.setGuarantee(product.get().getGuarantee());
            dto.setDescription(product.get().getDescription());
            dto.setIdImage(product.get().getImage().getId());
            dto.setCategory(product.get().getCategory().getName());
            dto.setIdCategory(product.get().getCategory().getId());
            dto.setIdManufacturer(product.get().getManufacturer().getId());
            dto.setManufacturer(product.get().getManufacturer().getName());
            dto.setOS(product.get().getLaptop().getOS());
            dto.setWeight(product.get().getWeight());
            dto.setPort(product.get().getLaptop().getPort());
            dto.setBattery(product.get().getLaptop().getBattery());
            dto.setModelCode(product.get().getModelCode());
            dto.setNational(product.get().getManufacturer().getNational());
            dto.setStatus(product.get().getStatus());
            dto.setPrice(product.get().getPrice());
            dto.setAmount(product.get().getAmount());
            dto.setScreen(product.get().getLaptop().getScreen());
            dto.setGraphicCard(product.get().getLaptop().getGraphicCard());
            dto.setName(product.get().getName());
            dto.setStorage(product.get().getLaptop().getStorage());
            dto.setRam(product.get().getLaptop().getRam());
            dto.setYear(product.get().getYear());
            dto.setCpu(product.get().getLaptop().getCpu());
            dto.setId(product.get().getId());
            Map<String, Object> response = new HashMap<>();
            response.put("Laptop", dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
