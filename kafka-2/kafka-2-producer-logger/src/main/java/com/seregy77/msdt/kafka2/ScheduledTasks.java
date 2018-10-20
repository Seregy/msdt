package com.seregy77.msdt.kafka2;

import com.seregy77.msdt.kafka2.domain.Purchase;
import com.seregy77.msdt.kafka2.service.ProducerLogger;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class ScheduledTasks {
    private final ProducerLogger producerLogger;

    @Scheduled(fixedRate = 5 * 1000)
    public void sendNewMessage() {
        producerLogger.send("log", new Purchase(UUID.randomUUID()));
    }
}
