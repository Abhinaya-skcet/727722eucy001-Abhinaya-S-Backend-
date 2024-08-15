package com.example.RestaurantBackend.repository;

import com.example.RestaurantBackend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
    @Query("SELECT DISTINCT r.userEmail FROM Reservation r")
    List<String> findDistinctUserEmails();
    
    @Query("SELECT r FROM Reservation r WHERE r.userEmail = :email")
    List<Reservation> findByUserEmail(@Param("email") String email);
    
    List<Reservation> findByStatus(String status);
}
