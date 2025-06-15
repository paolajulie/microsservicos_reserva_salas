package com.reservasala.reserva.shared.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UpdateBookingRequest {
    private LocalDateTime initDate;
    private LocalDateTime endDate;
} 