package com.seregy77.msdt.cqrs.command.rest.service;

import com.seregy77.msdt.cqrs.domain.command.PurchaseTicketCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@AllArgsConstructor
@Service
public class CommandService {
    private static final String TOPIC = "purchase";

    private final KafkaTemplate<String, PurchaseTicketCommand> kafkaTemplate;

    public void send(PurchaseTicketCommand payload) {
        kafkaTemplate.send(TOPIC, payload);
        log.info("{} [{}] Message sent: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), TOPIC, payload);
    }
}