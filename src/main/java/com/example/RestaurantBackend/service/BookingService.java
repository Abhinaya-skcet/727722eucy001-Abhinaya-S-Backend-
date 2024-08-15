package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking addBooking(Booking booking);
    List<Booking> getAllBookings();
    void deleteBookingByEmail(String email); 
}
