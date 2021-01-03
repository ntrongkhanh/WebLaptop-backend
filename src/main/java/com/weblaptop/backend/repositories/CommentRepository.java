package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CartEntity;
import com.weblaptop.backend.models.ENTITY.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    @Query(value = "select * from Comment  where id_product=?1", nativeQuery = true)
    public List<CommentEntity> findAllByProduct(long id);

}
