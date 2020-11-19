package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CategoryAccessoriesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAccessoriesDetailRepository extends JpaRepository<CategoryAccessoriesDetail,Long> {
}
