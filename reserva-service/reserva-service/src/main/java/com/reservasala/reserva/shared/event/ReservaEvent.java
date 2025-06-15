package com.reservasala.reserva.shared.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaEvent {
    private Long reservaId;
    private Long salaId;
    private Long usuarioId;
    private LocalDateTime dataHora;
    private String tipoEvento; // CRIADA, CANCELADA, MODIFICADA
    private String status;
} 