package com.reservas.usuarioservice.service;

import com.reservas.usuarioservice.event.ReservaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservaEventConsumer {

    private final EmailService emailService;

    @Bean
    public Consumer<ReservaEvent> reservaEventConsumer() {
        return evento -> {
            log.info("Recebido evento de reserva: {}", evento);
            switch (evento.getTipoEvento()) {
                case "CRIADA":
                    emailService.enviarEmailConfirmacaoReserva(evento);
                    break;
                case "CANCELADA":
                    emailService.enviarEmailCancelamentoReserva(evento);
                    break;
                case "MODIFICADA":
                    emailService.enviarEmailModificacaoReserva(evento);
                    break;
                default:
                    log.warn("Tipo de evento desconhecido: {}", evento.getTipoEvento());
            }
        };
    }
} 