package com.reservasala.salas.application.service;

import com.reservasala.salas.domain.models.Room;
import com.reservasala.salas.infrastructure.repositories.RoomRepository;
import com.reservasala.salas.shared.dto.CreateRoomRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public Room createRoom(CreateRoomRequest request) {
        Room room = new Room(null, request.getName(), request.getCapacity(), true);
        return roomRepository.save(room);
    }

    public List<Room> listRooms() {
        return roomRepository.findAll();
    }
}




