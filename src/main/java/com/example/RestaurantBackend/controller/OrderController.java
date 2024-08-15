package com.example.RestaurantBackend.controller;

import com.example.RestaurantBackend.entity.Order;
import com.example.RestaurantBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*@PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order savedOrder = orderService.placeOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }*/
    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order orderRequest) {
        try {
            orderService.placeOrder(orderRequest);
            return ResponseEntity.ok("Order placed successfully");
        } catch (Exception e) {
            // Log the error for debugging
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, "Order placement failed", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to place order. Please try again later.");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(o -> new ResponseEntity<>(o, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
