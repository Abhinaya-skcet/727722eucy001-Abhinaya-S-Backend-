package com.example.RestaurantBackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.RestaurantBackend.entity.Reservation;
import com.example.RestaurantBackend.repository.ReservationRepository;
import com.example.RestaurantBackend.service.ReservationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservationStatus(Long reservationId, String status) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setStatus(status);
        Reservation updatedReservation = reservationRepository.save(reservation);
		return updatedReservation;
    }
        // Send real-time update
        

    @Override
    public List<Reservation> getPendingReservations() {
        return reservationRepository.findByStatus("PENDING");
    }
    
    @Override
    public List<Reservation> getReservationsByUserEmail(String email) {
        return reservationRepository.findByUserEmail(email);
    }

    @Override
    public List<Reservation> getUniqueEmailReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .collect(Collectors.groupingBy(Reservation::getUserEmail))
                .values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
