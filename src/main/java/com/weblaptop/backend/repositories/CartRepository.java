package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
