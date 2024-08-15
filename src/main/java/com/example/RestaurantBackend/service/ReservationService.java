package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation updateReservationStatus(Long reservationId, String status);
    List<Reservation> getPendingReservations();
    List<Reservation> getReservationsByUserEmail(String email);
    List<Reservation> getUniqueEmailReservations();  // New method for unique email reservations
}
