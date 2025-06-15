package com.reservasala.salas.shared.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoomRequest {
    private String name;
    private Integer capacity;
    private Boolean available;
} 