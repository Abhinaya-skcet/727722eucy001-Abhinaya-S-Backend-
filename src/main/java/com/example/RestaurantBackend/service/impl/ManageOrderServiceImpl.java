package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.entity.ManageOrder;
import com.example.RestaurantBackend.repository.ManageOrderRepository;
import com.example.RestaurantBackend.service.ManageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ManageOrderServiceImpl implements ManageOrderService {

    @Autowired
    private ManageOrderRepository manageOrderRepository;

    @Override
    public ManageOrder placeOrder(ManageOrder manageOrder) {
        return manageOrderRepository.save(manageOrder);
    }

    @Override
    public Optional<ManageOrder> getOrderById(Long id) {
        return manageOrderRepository.findById(id);
    }

    @Override
    public List<ManageOrder> getAllOrders() {
        return manageOrderRepository.findAll();
    }

    @Override
    public List<ManageOrder> getOrdersByCustomerEmail(String userEmail) {
        return manageOrderRepository.findByUserEmail(userEmail);
    }

    @Override
    public ManageOrder updateOrderStatus(Long orderId, String status) {
        Optional<ManageOrder> orderOptional = manageOrderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            ManageOrder order = orderOptional.get();
            order.setStatus(status);
            return manageOrderRepository.save(order);
        }
        return null;
    }
}
