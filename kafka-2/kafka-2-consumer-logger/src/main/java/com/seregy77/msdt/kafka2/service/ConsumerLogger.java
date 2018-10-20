package com.seregy77.msdt.kafka2.service;

import com.seregy77.msdt.kafka2.domain.Purchase;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class ConsumerLogger {
    @KafkaListener(topics = "log")
    public void receiveLogTopic(ConsumerRecord<String, Purchase> record) {
        log.info("{} [{}-{}] | Received message: {}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), record.topic(), record.partition(), record.value());
    }
}
