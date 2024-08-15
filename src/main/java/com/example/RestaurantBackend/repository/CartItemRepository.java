package com.example.RestaurantBackend.repository;

import com.example.RestaurantBackend.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
