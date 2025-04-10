package com.reservasala.salas.shared.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreateRoomRequest {
    private String name;
    private Integer capacity;
}


