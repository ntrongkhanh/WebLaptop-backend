package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public  Optional<User> findByEmail(String email);
    public  boolean existsByToken(String token);

}
