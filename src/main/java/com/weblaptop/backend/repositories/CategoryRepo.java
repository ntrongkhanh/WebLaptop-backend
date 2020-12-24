package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo  extends JpaRepository<CategoryEntity,Long> {
//    @Query(value = "select * from category c where c.name like %:name%", nativeQuery = true)
//    public CategoryEntity getByName(@Param("name") String name);
}
