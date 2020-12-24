package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<LaptopEntity,Long> {
}
