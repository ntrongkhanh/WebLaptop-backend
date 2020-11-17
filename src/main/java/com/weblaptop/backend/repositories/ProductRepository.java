package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    @Query(value = "Select product.* from product, laptop_detail where is_Laptop=1 and id_product=product.id",nativeQuery = true)
//    ArrayList<Product> findAlLaptop();
}
