package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.Keyboard;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepo extends JpaRepository<Keyboard,Long> {
    @Query(value = "select * from product p where c.id_product_type=4", nativeQuery = true)
    public Product findAllProduct();
}
