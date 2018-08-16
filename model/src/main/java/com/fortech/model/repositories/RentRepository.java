package com.fortech.model.repositories;

import com.fortech.model.entities.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface    RentRepository extends JpaRepository<RentEntity, Long> {
}
