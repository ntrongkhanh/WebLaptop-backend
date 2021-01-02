package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CartEntity;
import com.weblaptop.backend.models.ENTITY.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity,Long> {
    @Query(value = "select * from orders where id_user=?1", nativeQuery = true)
    List<OrdersEntity> findAllByUser(long id);
}
