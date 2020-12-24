package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepo extends JpaRepository<ManufacturerEntity,Long> {
}
