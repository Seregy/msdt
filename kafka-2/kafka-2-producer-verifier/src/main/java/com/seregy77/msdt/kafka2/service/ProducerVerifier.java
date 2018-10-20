package com.seregy77.msdt.kafka2.service;

import com.seregy77.msdt.kafka2.domain.Purchase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@AllArgsConstructor
@Service
public class ProducerVerifier {
    private final KafkaTemplate<String, Purchase> kafkaTemplate;

    public void send(String topic, Purchase payload) {
        kafkaTemplate.send(topic, payload);
        log.info("{} [{}] Message sent: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), topic, payload);
    }
}
