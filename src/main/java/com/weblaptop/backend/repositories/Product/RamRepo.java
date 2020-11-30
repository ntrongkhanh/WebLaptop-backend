package com.weblaptop.backend.repositories.Product;

import com.weblaptop.backend.models.ENTITY.Product.Product;
import com.weblaptop.backend.models.ENTITY.Product.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepo extends JpaRepository<Ram,Long> {

}
