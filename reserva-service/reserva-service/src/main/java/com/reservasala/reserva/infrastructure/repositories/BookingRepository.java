package com.reservasala.reserva.infrastructure.repositories;

import com.reservasala.reserva.domain.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    void deleteByUserId(Long userId);
}


