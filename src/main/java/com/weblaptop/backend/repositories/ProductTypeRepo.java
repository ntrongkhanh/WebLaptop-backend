package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import com.weblaptop.backend.models.ENTITY.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepo extends JpaRepository<ProductType,Long> {
    @Query(value = "select * from product_type c where c.name like %:name%", nativeQuery = true)
    public ProductType getByName(@Param("name") String name);
}
