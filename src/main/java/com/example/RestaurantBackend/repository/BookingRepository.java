package com.example.RestaurantBackend.repository;

import com.example.RestaurantBackend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	void deleteByEmail(String email);
}
