package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.Laptop;
import com.weblaptop.backend.models.ENTITY.Product.Mouse;
import com.weblaptop.backend.models.ENTITY.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MouseRepo extends JpaRepository<Mouse,Long> {
}
