package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepo extends JpaRepository<StorageEntity,Long> {
}
