package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.RamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepository extends JpaRepository<RamEntity,Long> {

}
