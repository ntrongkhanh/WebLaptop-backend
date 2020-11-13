package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.DemoEntity;
import com.weblaptop.backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<Product,Long>{

}