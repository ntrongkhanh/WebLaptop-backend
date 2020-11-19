package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.RateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateDetailRepository extends JpaRepository<RateDetail,Long> {
}
