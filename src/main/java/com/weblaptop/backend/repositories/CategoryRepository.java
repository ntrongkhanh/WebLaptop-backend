package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "select * from category c where c.name like %:name% and c.is_laptop=1", nativeQuery = true)
    public List<Category> getByName(@Param("name") String name);

}
