package com.reservasala.salas.shared.exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id) {
        super("Sala não encontrada com ID: " + id);
    }
} 