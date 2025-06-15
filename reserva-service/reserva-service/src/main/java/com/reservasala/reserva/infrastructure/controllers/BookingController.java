package com.reservasala.reserva.infrastructure.controllers;

import com.reservasala.reserva.application.service.BookingService;
import com.reservasala.reserva.domain.models.Booking;
import com.reservasala.reserva.shared.dto.CreateBookingRequest;
import com.reservasala.reserva.shared.dto.UpdateBookingRequest;
import com.reservasala.reserva.shared.exceptions.BookingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody CreateBookingRequest request) {
        return ResponseEntity.ok(bookingService.createBooking(request));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> list() {
        return ResponseEntity.ok(bookingService.listReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bookingService.getBookingById(id));
        } catch (BookingNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> update(@PathVariable Long id, @RequestBody UpdateBookingRequest request) {
        try {
            return ResponseEntity.ok(bookingService.updateBooking(id, request));
        } catch (BookingNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        try {
            bookingService.cancelBooking(id);
            return ResponseEntity.noContent().build();
        } catch (BookingNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

