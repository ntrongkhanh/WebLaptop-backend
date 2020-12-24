package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity,Long> {
    @Query(value = "select * from product_type c where c.name like %:name%", nativeQuery = true)
    public ProductTypeEntity getByName(@Param("name") String name);
}
