package com.reservasala.reserva.shared.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEvent {
    private Long usuarioId;
    private String tipoEvento; // DELETADO
    private String motivo;
} 