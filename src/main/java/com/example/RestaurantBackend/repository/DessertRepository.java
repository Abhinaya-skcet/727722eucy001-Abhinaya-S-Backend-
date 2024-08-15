package com.example.RestaurantBackend.repository;

import com.example.RestaurantBackend.entity.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertRepository extends JpaRepository<Dessert, Long> {
}
