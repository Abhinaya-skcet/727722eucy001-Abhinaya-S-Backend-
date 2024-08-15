package com.example.RestaurantBackend.controller;

import com.example.RestaurantBackend.dto.ReservationDTO;
import com.example.RestaurantBackend.entity.Reservation;
import com.example.RestaurantBackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = convertToEntity(reservationDTO);
        Reservation savedReservation = reservationService.createReservation(reservation);
        ReservationDTO savedReservationDTO = convertToDTO(savedReservation);
        return ResponseEntity.ok(savedReservationDTO);
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        List<ReservationDTO> reservationDTOs = reservations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservationDTOs);
    }

    @GetMapping("/unique")
    public ResponseEntity<Map<String, List<ReservationDTO>>> getUniqueReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();

        // Group reservations by email
        Map<String, List<ReservationDTO>> groupedReservations = reservations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.groupingBy(ReservationDTO::getUserEmail));

        return ResponseEntity.ok(groupedReservations);
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<List<ReservationDTO>> getReservationsByUserEmail(@PathVariable String email) {
        List<Reservation> reservations = reservationService.getReservationsByUserEmail(email);
        List<ReservationDTO> reservationDTOs = reservations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservationDTOs);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> updateReservationStatus(
            @PathVariable Long reservationId, 
            @RequestBody Map<String, String> requestBody) {
        String status = requestBody.get("status");
        if (status == null) {
            return ResponseEntity.badRequest().body(null);
        }
        
        Reservation updatedReservation = reservationService.updateReservationStatus(reservationId, status);
        ReservationDTO updatedReservationDTO = convertToDTO(updatedReservation);
        return ResponseEntity.ok(updatedReservationDTO);
    }

    private Reservation convertToEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setReservationDate(dto.getReservationDate());
        reservation.setStatus(dto.getStatus());
        reservation.setUserEmail(dto.getUserEmail());
        return reservation;
    }

    private ReservationDTO convertToDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setReservationDate(reservation.getReservationDate());
        dto.setStatus(reservation.getStatus());
        dto.setUserEmail(reservation.getUserEmail());
        return dto;
    }
}
