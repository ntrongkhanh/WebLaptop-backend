package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.AccessoriesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoriesDetailRepository extends JpaRepository<AccessoriesDetail,Long> {
}
