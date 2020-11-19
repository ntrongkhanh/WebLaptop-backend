package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
