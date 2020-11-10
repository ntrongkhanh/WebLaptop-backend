package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.entities.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity,Long>{

}