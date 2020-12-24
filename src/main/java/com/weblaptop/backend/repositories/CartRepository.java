package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CartEntity;
import com.weblaptop.backend.models.ENTITY.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {
    public Optional<CartEntity> findByUser(long id);
}
