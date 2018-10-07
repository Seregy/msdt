package com.seregy77.kafka1.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seregy77.kafka1.domain.Purchase;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
@Slf4j
public class KafkaPurchaseDeserializer implements Deserializer<Purchase> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Purchase deserialize(String topic, byte[] data) {
        Purchase purchase = null;

        try {
            purchase = objectMapper.readValue(new String(data, StandardCharsets.UTF_8), Purchase.class);
        } catch (IOException e) {
            log.error("Unable to deserialize message {}", data, e);
        }

        return purchase;
    }

    @Override
    public void close() {
    }
}
