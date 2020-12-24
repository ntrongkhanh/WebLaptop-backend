package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CartEntity;
import com.weblaptop.backend.models.ENTITY.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity,Long> {
    public List<OrdersEntity> findAllByUser(long id);
}
