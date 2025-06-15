package com.reservasala.salas.infrastructure.controllers;

import com.reservasala.salas.application.service.RoomService;
import com.reservasala.salas.domain.models.Room;
import com.reservasala.salas.shared.dto.CreateRoomRequest;
import com.reservasala.salas.shared.dto.UpdateRoomRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public Room create(@RequestBody CreateRoomRequest request) {
        return roomService.createRoom(request);
    }

    @GetMapping
    public List<Room> list() {
        return roomService.listRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        return ResponseEntity.ok(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> update(@PathVariable Long id, @RequestBody UpdateRoomRequest request) {
        Room updatedRoom = roomService.updateRoom(id, request);
        return ResponseEntity.ok(updatedRoom);
    }
}

