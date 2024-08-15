package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(Order order);  // Make sure this matches
    Optional<Order> getOrderById(Long id);
    List<Order> getAllOrders();
}
