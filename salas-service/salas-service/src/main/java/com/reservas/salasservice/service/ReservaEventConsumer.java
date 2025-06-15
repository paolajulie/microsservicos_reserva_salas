package com.reservas.salasservice.service;

import com.reservas.salasservice.event.ReservaEvent;
import com.reservasala.salas.infrastructure.repositories.RoomRepository;
import com.reservasala.salas.domain.models.Room;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservaEventConsumer {

    private final RoomRepository roomRepository;

    @Bean
    public Consumer<ReservaEvent> reservaEventConsumer() {
        return evento -> {
            log.info("Recebido evento de reserva: {}", evento);
            switch (evento.getTipoEvento()) {
                case "CRIADA":
                    atualizarDisponibilidadeSala(evento.getSalaId(), false);
                    break;
                case "CANCELADA":
                    atualizarDisponibilidadeSala(evento.getSalaId(), true);
                    break;
                case "MODIFICADA":
                    log.info("Evento de modificação recebido para a sala: {}", evento.getSalaId());
                    break;
                default:
                    log.warn("Tipo de evento desconhecido: {}", evento.getTipoEvento());
            }
        };
    }

    private void atualizarDisponibilidadeSala(Long salaId, boolean disponivel) {
        roomRepository.findById(salaId).ifPresent(sala -> {
            sala.setAvailable(disponivel);
            roomRepository.save(sala);
            log.info("Disponibilidade da sala {} atualizada para: {}", salaId, disponivel);
        });
    }
} 