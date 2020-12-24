package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.KeyboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<KeyboardEntity,Long> {

}
