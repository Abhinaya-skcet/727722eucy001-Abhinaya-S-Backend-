package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.entity.Order;
import com.example.RestaurantBackend.entity.OrderItem;
import com.example.RestaurantBackend.repository.OrderRepository;
import com.example.RestaurantBackend.service.OrderService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public Order placeOrder(Order order) {  // Ensure this matches the interface
        // Calculate total price
        BigDecimal totalPrice = order.getItems().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalPrice(totalPrice);

        // Set the order reference on each OrderItem
        for (OrderItem item : order.getItems()) {
            item.setOrder(order);
        }

        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    
    
    
}
