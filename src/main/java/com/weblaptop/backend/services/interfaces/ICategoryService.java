package com.weblaptop.backend.services.interfaces;

import com.weblaptop.backend.models.DTO.CategoryLaptopDTO;
import com.weblaptop.backend.models.ENTITY.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.RelationException;
import java.util.List;
import java.util.Map;

@Service
public interface ICategoryService {
    // LAPTOP
    public ResponseEntity<Map<String, Object>>  createCategoryLaptop(CategoryLaptopDTO categoryLaptopDTO) ;
    public void  deleteCategoryLaptop(long id) ;
    public ResponseEntity<Map<String, Object>>  updateCategoryLaptop(CategoryLaptopDTO categoryLaptopDTO);
    public ResponseEntity<Map<String, Object>>  getAllCategoryLaptop() ;
    public ResponseEntity<Map<String, Object>>  getByIdCategoryLaptop(long id) ;
    public ResponseEntity<Map<String, Object>>  getByNameCategoryLaptop(String name) ;


    //////////////////////////
    //Phụ kiện
    //////////////////////
}
