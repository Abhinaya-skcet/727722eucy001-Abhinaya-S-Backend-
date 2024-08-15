package com.example.RestaurantBackend.repository;

import com.example.RestaurantBackend.entity.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {
}
