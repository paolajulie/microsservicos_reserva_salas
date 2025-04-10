package com.reservasala.reserva.shared.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreateBookingRequest {
    private Long roomId;
    private Long userId;
    private LocalDateTime init;
    private LocalDateTime end;
}

