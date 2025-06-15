package com.reservasala.salas.application.service;

import com.reservasala.salas.domain.models.Room;
import com.reservasala.salas.infrastructure.repositories.RoomRepository;
import com.reservasala.salas.shared.dto.CreateRoomRequest;
import com.reservasala.salas.shared.dto.UpdateRoomRequest;
import com.reservasala.salas.shared.exceptions.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    @Transactional
    public Room updateRoom(Long id, UpdateRoomRequest request) {
        Room room = getRoomById(id);
        
        if (request.getName() != null) {
            room.setName(request.getName());
        }
        if (request.getCapacity() != null) {
            room.setCapacity(request.getCapacity());
        }
        if (request.getAvailable() != null) {
            room.setAvailable(request.getAvailable());
        }
        
        return roomRepository.save(room);
    }
}




