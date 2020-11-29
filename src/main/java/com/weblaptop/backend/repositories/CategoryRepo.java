package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.Category;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo  extends JpaRepository<Category,Long> {
//    @Query(value = "select * from category c where c.name like %:name%", nativeQuery = true)
//    public Category getByName(@Param("name") String name);
}
