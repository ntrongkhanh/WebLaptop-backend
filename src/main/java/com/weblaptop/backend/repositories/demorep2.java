package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.LaptopDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface demorep2 extends JpaRepository<LaptopDetail,Long> {

}
