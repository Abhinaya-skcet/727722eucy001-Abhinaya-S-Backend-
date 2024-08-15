package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.entity.ManageOrder;
import java.util.List;
import java.util.Optional;

public interface ManageOrderService {
	ManageOrder placeOrder(ManageOrder manageOrder);
    Optional<ManageOrder> getOrderById(Long id);
    List<ManageOrder> getAllOrders();
    List<ManageOrder> getOrdersByCustomerEmail(String userEmail);
    ManageOrder updateOrderStatus(Long orderId, String status);}
