package com.reservasala.reserva.infrastructure.controllers;

import com.reservasala.reserva.application.service.BookingService;
import com.reservasala.reserva.domain.models.Booking;
import com.reservasala.reserva.shared.dto.CreateBookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public Booking create(@RequestBody CreateBookingRequest request) {
        return bookingService.createBooking(request);
    }

    @GetMapping
    public List<Booking> list() {
        return bookingService.listReservations();
    }
}

