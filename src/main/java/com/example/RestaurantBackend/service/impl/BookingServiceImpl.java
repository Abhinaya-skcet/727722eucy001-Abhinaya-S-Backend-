package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.entity.Booking;
import com.example.RestaurantBackend.repository.BookingRepository;
import com.example.RestaurantBackend.service.BookingService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public interface BookingService {
        Booking addBooking(Booking booking);
        List<Booking> getAllBookings();
        boolean deleteBooking(Long userEmail); // New method to delete a booking
    }
    
    @Override
    @Transactional // Ensure this method runs within a transaction
    public void deleteBookingByEmail(String email) {
        bookingRepository.deleteByEmail(email);
    }
}
