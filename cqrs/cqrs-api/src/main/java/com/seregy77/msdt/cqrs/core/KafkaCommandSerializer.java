package com.seregy77.msdt.cqrs.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seregy77.msdt.cqrs.domain.command.PurchaseTicketCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class KafkaCommandSerializer implements Serializer<PurchaseTicketCommand> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, PurchaseTicketCommand data) {
        byte[] result = null;

        try {
            result = objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize object {}", data, e);
        }

        return result;
    }

    @Override
    public void close() {
    }
}
