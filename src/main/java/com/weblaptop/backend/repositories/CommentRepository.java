package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
