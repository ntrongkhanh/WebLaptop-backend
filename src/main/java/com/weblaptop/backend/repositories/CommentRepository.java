package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    @Query(value = "select * from Comment  where id_product=?1 and id_parent is null", nativeQuery = true)
    public List<CommentEntity> findAllByProduct(long id);
}
