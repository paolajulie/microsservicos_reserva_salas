package com.reservasala.reserva.application.service.event;

import com.reservasala.reserva.shared.event.UsuarioEvent;
import com.reservasala.reserva.infrastructure.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
@RequiredArgsConstructor
public class UsuarioEventConsumer implements Consumer<UsuarioEvent> {

    private final BookingRepository bookingRepository;

    @Override
    public void accept(UsuarioEvent evento) {
        log.info("Recebido evento de usuário: {}", evento);
        if ("DELETADO".equals(evento.getTipoEvento())) {
            log.info("Removendo reservas do usuário: {}", evento.getUsuarioId());
            bookingRepository.deleteByUserId(evento.getUsuarioId());
        }
    }
} 