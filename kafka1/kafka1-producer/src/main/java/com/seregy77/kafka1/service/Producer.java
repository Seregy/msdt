package com.seregy77.kafka1.service;

import com.seregy77.kafka1.domain.Purchase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class Producer {
    private final KafkaTemplate<String, Purchase> kafkaTemplate;

    public void send(String topic, Purchase payload) {
        kafkaTemplate.send(topic, payload);
        log.info("[Topic {}] Message sent: {}", topic, payload);
    }
}
