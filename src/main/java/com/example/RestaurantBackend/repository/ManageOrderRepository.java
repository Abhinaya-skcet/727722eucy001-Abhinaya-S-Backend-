package com.example.RestaurantBackend.repository;

import com.example.RestaurantBackend.entity.ManageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ManageOrderRepository extends JpaRepository<ManageOrder, Long> {
    List<ManageOrder> findByUserEmail(String userEmail);
}
