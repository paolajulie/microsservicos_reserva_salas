package com.reservasala.salas.infrastructure.repositories;

import com.reservasala.salas.domain.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomRepository extends JpaRepository<Room, Long> {
}

