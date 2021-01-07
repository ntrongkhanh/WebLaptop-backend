package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CartDetailEntity;
import com.weblaptop.backend.models.ENTITY.CartEntity;
import com.weblaptop.backend.models.ENTITY.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartDetailRepository extends JpaRepository<CartDetailEntity,Long> {
    @Query(value = "select * from orders_detail  where id_order=?1", nativeQuery = true)
    List<CartDetailEntity> findAllByOrdersEntity(long id);
}
