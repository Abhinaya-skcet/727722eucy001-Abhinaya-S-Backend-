package com.example.RestaurantBackend.controller;

import com.example.RestaurantBackend.entity.ManageOrder;
import com.example.RestaurantBackend.service.ManageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manage-orders")
@CrossOrigin(origins = "http://localhost:3000")
public class ManageOrderController {

    @Autowired
    private ManageOrderService manageOrderService;

    @PostMapping
    public ResponseEntity<ManageOrder> placeOrder(@RequestBody ManageOrder manageOrder) {
        ManageOrder savedOrder = manageOrderService.placeOrder(manageOrder);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManageOrder> getOrder(@PathVariable Long id) {
        return manageOrderService.getOrderById(id)
                .map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/customer/{userEmail}")
    public ResponseEntity<List<ManageOrder>> getOrdersByCustomer(@PathVariable String userEmail) {
        List<ManageOrder> orders = manageOrderService.getOrdersByCustomerEmail(userEmail);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ManageOrder>> getAllOrders() {
        List<ManageOrder> orders = manageOrderService.getAllOrders();
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        ManageOrder updatedOrder = manageOrderService.updateOrderStatus(orderId, status);
        if (updatedOrder != null) {
            return ResponseEntity.ok("Order status updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
    }
}
