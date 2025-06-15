package com.reservasala.reserva.application.service;

import com.reservasala.reserva.application.service.event.ReservaEventService;
import com.reservasala.reserva.domain.models.Booking;
import com.reservasala.reserva.infrastructure.repositories.BookingRepository;
import com.reservasala.reserva.shared.dto.CreateBookingRequest;
import com.reservasala.reserva.shared.dto.UpdateBookingRequest;
import com.reservasala.reserva.shared.exceptions.BookingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ReservaEventService reservaEventService;

    public Booking createBooking(CreateBookingRequest request) {
        Booking booking = new Booking(null, request.getRoomId(), request.getUserId(), request.getInitDate(), request.getEndDate());
        booking = bookingRepository.save(booking);
        reservaEventService.publicarEventoReservaCriada(booking.getId(), booking.getRoomId(), booking.getUserId());
        return booking;
    }

    public List<Booking> listReservations() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
            .orElseThrow(() -> new BookingNotFoundException("Reserva não encontrada com ID: " + id));
    }

    @Transactional
    public Booking updateBooking(Long id, UpdateBookingRequest request) {
        Booking booking = getBookingById(id);
        
        if (request.getInitDate() != null) {
            booking.setInitDate(request.getInitDate());
        }
        if (request.getEndDate() != null) {
            booking.setEndDate(request.getEndDate());
        }

        booking = bookingRepository.save(booking);
        reservaEventService.publicarEventoReservaModificada(booking.getId(), booking.getRoomId(), booking.getUserId());
        return booking;
    }

    @Transactional
    public void cancelBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
        reservaEventService.publicarEventoReservaCancelada(booking.getId(), booking.getRoomId(), booking.getUserId());
    }
}
