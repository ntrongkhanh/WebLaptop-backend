package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<ImageEntity,Long> {
}
