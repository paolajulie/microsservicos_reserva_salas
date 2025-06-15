package com.reservas.usuarioservice.service;

import com.reservas.usuarioservice.event.ReservaEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    public void enviarEmailConfirmacaoReserva(ReservaEvent evento) {
        // TODO: Implementar integração com serviço de email
        log.info("Enviando email de confirmação de reserva para o usuário {} - Reserva: {}", 
            evento.getUsuarioId(), evento.getReservaId());
    }

    public void enviarEmailCancelamentoReserva(ReservaEvent evento) {
        // TODO: Implementar integração com serviço de email
        log.info("Enviando email de cancelamento de reserva para o usuário {} - Reserva: {}", 
            evento.getUsuarioId(), evento.getReservaId());
    }

    public void enviarEmailModificacaoReserva(ReservaEvent evento) {
        // TODO: Implementar integração com serviço de email
        log.info("Enviando email de modificação de reserva para o usuário {} - Reserva: {}", 
            evento.getUsuarioId(), evento.getReservaId());
    }
} 