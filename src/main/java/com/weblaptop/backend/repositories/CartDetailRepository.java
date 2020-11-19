package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail,Long> {
}
