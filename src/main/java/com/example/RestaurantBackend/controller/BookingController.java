package com.example.RestaurantBackend.controller;

import com.example.RestaurantBackend.entity.Booking;
import com.example.RestaurantBackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the URL if necessary
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        Booking createdBooking = bookingService.addBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteBookingByEmail(@PathVariable String email) {
        bookingService.deleteBookingByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
