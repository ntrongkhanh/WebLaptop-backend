package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.Laptop;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query(value = "select * from product p where p.id_product_type=100001", nativeQuery = true)
    public List<Product> findAllLaptop();
    @Query(value = "select * from product p where p.id_product_type=100002", nativeQuery = true)
    public List<Product> findAllRam();
    @Query(value = "select * from product p where p.id_product_type=100003", nativeQuery = true)
    public List<Product> findAllStorage();
    @Query(value = "select * from product p where p.id_product_type=100004", nativeQuery = true)
    public List<Product> findAllKeyboard();
    @Query(value = "select * from product p where p.id_product_type=100005", nativeQuery = true)
    public List<Product> findAllMouse();

}
