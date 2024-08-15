package com.example.RestaurantBackend.repository;

import com.example.RestaurantBackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
}
