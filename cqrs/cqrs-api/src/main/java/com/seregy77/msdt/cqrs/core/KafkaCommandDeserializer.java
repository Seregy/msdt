package com.seregy77.msdt.cqrs.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seregy77.msdt.cqrs.domain.command.PurchaseTicketCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
@Slf4j
public class KafkaCommandDeserializer implements Deserializer<PurchaseTicketCommand> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public PurchaseTicketCommand deserialize(String topic, byte[] data) {
        PurchaseTicketCommand command = null;

        try {
            command = objectMapper.readValue(new String(data, StandardCharsets.UTF_8), PurchaseTicketCommand.class);
        } catch (IOException e) {
            log.error("Unable to deserialize message {}", data, e);
        }

        return command;
    }

    @Override
    public void close() {
    }
}
