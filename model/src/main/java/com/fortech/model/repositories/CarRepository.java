package com.fortech.model.repositories;

import com.fortech.model.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface    CarRepository extends JpaRepository<Car, Long> {
}
