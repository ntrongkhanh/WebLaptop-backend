package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,Long> {
    @Query(value = "select * from product p where p.id_product_type=100001", nativeQuery = true)
    public List<ProductEntity> findAllLaptop();
    @Query(value = "select * from product p where p.id_product_type=100002", nativeQuery = true)
    public List<ProductEntity> findAllRam();
    @Query(value = "select * from product p where p.id_product_type=100003", nativeQuery = true)
    public List<ProductEntity> findAllStorage();
    @Query(value = "select * from product p where p.id_product_type=100004", nativeQuery = true)
    public List<ProductEntity> findAllKeyboard();
    @Query(value = "select * from product p where p.id_product_type=100005", nativeQuery = true)
    public List<ProductEntity> findAllMouse();

}
