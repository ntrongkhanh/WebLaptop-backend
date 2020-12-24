package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.MouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouseRepository extends JpaRepository<MouseEntity,Long> {
}
