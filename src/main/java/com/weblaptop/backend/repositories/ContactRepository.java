package com.weblaptop.backend.repositories;

import com.weblaptop.backend.models.ENTITY.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository  extends JpaRepository<Contact,Long> {
}
