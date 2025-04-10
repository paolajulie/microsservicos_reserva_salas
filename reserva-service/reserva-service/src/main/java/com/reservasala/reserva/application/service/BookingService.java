package com.reservasala.reserva.application.service;

import com.reservasala.reserva.domain.models.Booking;
import com.reservasala.reserva.infrastructure.repositories.BookingRepository;
import com.reservasala.reserva.shared.dto.CreateBookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public Booking createBooking(CreateBookingRequest request) {
        Booking book = new Booking(null, request.getRoomId(), request.getUserId(), request.getInitDate(), request.getEndDate());
        return bookingRepository.save(book);
    }

    public List<Booking> listReservations() {
        return bookingRepository.findAll();
    }
}
