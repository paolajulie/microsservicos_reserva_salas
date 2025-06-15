package com.reservasala.reserva.application.service.event;

import com.reservasala.reserva.shared.event.ReservaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservaEventService {

    private final StreamBridge streamBridge;

    public void publicarEventoReservaCriada(Long reservaId, Long salaId, Long usuarioId) {
        ReservaEvent evento = new ReservaEvent(
            reservaId,
            salaId,
            usuarioId,
            LocalDateTime.now(),
            "CRIADA",
            "CONFIRMADA"
        );
        streamBridge.send("reservaCriada-out-0", evento);
        log.info("Evento de reserva criada publicado: {}", evento);
    }

    public void publicarEventoReservaCancelada(Long reservaId, Long salaId, Long usuarioId) {
        ReservaEvent evento = new ReservaEvent(
            reservaId,
            salaId,
            usuarioId,
            LocalDateTime.now(),
            "CANCELADA",
            "CANCELADA"
        );
        streamBridge.send("reservaCancelada-out-0", evento);
        log.info("Evento de reserva cancelada publicado: {}", evento);
    }

    public void publicarEventoReservaModificada(Long reservaId, Long salaId, Long usuarioId) {
        ReservaEvent evento = new ReservaEvent(
            reservaId,
            salaId,
            usuarioId,
            LocalDateTime.now(),
            "MODIFICADA",
            "CONFIRMADA"
        );
        streamBridge.send("reservaModificada-out-0", evento);
        log.info("Evento de reserva modificada publicado: {}", evento);
    }
} 