package com.example.RestaurantBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RestaurantBackend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional query methods can be defined here
	
	
}
