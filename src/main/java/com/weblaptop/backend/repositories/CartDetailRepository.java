package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CartDetailEntity;
import com.weblaptop.backend.models.ENTITY.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CartDetailRepository extends JpaRepository<CartDetailEntity,Long> {
}
