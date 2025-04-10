package com.reservasala.salas.infrastructure.controllers;

import com.reservasala.salas.application.service.RoomService;
import com.reservasala.salas.domain.models.Room;
import com.reservasala.salas.shared.dto.CreateRoomRequest;
import lombok.RequiredArgsConstructor;
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
}

