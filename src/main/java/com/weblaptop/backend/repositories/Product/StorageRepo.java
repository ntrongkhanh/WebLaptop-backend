package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.Product;
import com.weblaptop.backend.models.ENTITY.Product.Storage;
import com.weblaptop.backend.models.ENTITY.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepo extends JpaRepository<Storage,Long> {
    @Query(value = "select * from product p where c.id_product_type=3", nativeQuery = true)
    public Product findAllProduct();
}
