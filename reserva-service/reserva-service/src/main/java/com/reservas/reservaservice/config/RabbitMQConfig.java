package com.reservas.reservaservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Sinks.Many<Message<Object>> reservaCriadaSink() {
        return Sinks.many().multicast().onBackpressureBuffer();
    }

    @Bean
    public Sinks.Many<Message<Object>> reservaCanceladaSink() {
        return Sinks.many().multicast().onBackpressureBuffer();
    }

    @Bean
    public Sinks.Many<Message<Object>> reservaModificadaSink() {
        return Sinks.many().multicast().onBackpressureBuffer();
    }

    @Bean
    public Supplier<Flux<Message<Object>>> reservaCriadaSupplier(Sinks.Many<Message<Object>> sink) {
        return () -> sink.asFlux();
    }

    @Bean
    public Supplier<Flux<Message<Object>>> reservaCanceladaSupplier(Sinks.Many<Message<Object>> sink) {
        return () -> sink.asFlux();
    }

    @Bean
    public Supplier<Flux<Message<Object>>> reservaModificadaSupplier(Sinks.Many<Message<Object>> sink) {
        return () -> sink.asFlux();
    }
} 