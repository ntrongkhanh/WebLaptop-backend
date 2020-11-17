package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.LaptopDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopDetailRepository extends JpaRepository<LaptopDetail,Long> {
}
