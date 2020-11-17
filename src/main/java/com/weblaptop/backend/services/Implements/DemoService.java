package com.weblaptop.backend.services.Implements;
import com.weblaptop.backend.models.DTO.LaptopDTO;
import com.weblaptop.backend.models.ENTITY.LaptopDetail;
import com.weblaptop.backend.models.ENTITY.Product;
import com.weblaptop.backend.repositories.LaptopDetailRepository;
import com.weblaptop.backend.repositories.ProductRepository;
import com.weblaptop.backend.services.interfaces.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemoService implements IDemoService {

      @Autowired
      private LaptopDetailRepository laptopDetailRepository;
      @Autowired
      private ProductRepository productRepository;

      @Override
      public List<LaptopDTO> getAlldemo() {
            //List<Product> product=productRepository.findAlLaptop();
            List<LaptopDTO> listLaptopDTO = new ArrayList<>();
            List<LaptopDetail> listLaptopDetails=laptopDetailRepository.findAll();
            for (LaptopDetail laptopDetail:listLaptopDetails)
            {
                  Optional<Product> product=productRepository.findById(laptopDetail.getProduct().getId());
                  LaptopDTO laptopDTO=new LaptopDTO();
                  laptopDTO.setId(laptopDetail.getProduct().getId());
                  laptopDTO.setIdManufacturer(laptopDetail.getProduct().getManufacturer().getName());
                  laptopDTO.setIdCategory(laptopDetail.getProduct().getCategory().getName());
                  laptopDTO.setModelCode(laptopDetail.getProduct().getModelCode());
                  laptopDTO.setName(laptopDetail.getProduct().getName());
                  laptopDTO.setYear(laptopDetail.getProduct().getYear());
                  laptopDTO.setIdImage(laptopDetail.getProduct().getArrImage());
                  laptopDTO.setStatus(laptopDetail.getProduct().getStatus());
                  laptopDTO.setAmount(laptopDetail.getProduct().getAmount());
                  laptopDTO.setPrice(laptopDetail.getProduct().getPrice());


                  laptopDTO.setCpu(laptopDetail.getCpu());
                  laptopDTO.setRam(laptopDetail.getRam());
                  laptopDTO.setScreen(laptopDetail.getScreen());
                  laptopDTO.setGraphicCard(laptopDetail.getGraphicCard());
                  laptopDTO.setStorage(laptopDetail.getStorage());
                  laptopDTO.setBattery(laptopDetail.getBattery());
                  laptopDTO.setPort(laptopDetail.getPort());
                  laptopDTO.setWeight(laptopDetail.getWeight());
                  laptopDTO.setOS(laptopDetail.getOS());

                  listLaptopDTO.add(laptopDTO);
            }
            return listLaptopDTO;
      }


}
