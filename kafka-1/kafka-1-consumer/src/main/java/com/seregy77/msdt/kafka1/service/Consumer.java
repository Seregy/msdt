package com.seregy77.msdt.kafka1.service;

import com.seregy77.msdt.kafka1.domain.Purchase;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {
    @KafkaListener(topics = "log")
    @SendTo("verify")
    public Purchase receiveFirstTopic(ConsumerRecord<String, Purchase> record) {
        log.info("[Topic {}] | Received message: key - {}, value - {}", record.topic(), record.key(), record.value());

        Purchase purchase = record.value();
        purchase.setVerified(true);

        return purchase;
    }
}
