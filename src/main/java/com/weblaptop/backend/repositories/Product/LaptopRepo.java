package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.Laptop;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Long> {
    @Query(value = "select * from product p where c.id_product_type=1", nativeQuery = true)
    public Product findAllProduct();
}
