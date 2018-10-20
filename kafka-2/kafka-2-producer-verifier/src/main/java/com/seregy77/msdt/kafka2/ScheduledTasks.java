package com.seregy77.msdt.kafka2;

import com.seregy77.msdt.kafka2.domain.Purchase;
import com.seregy77.msdt.kafka2.service.ProducerVerifier;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class ScheduledTasks {
    private final ProducerVerifier producerVerifier;

    @Scheduled(fixedRate = 5 * 1000)
    public void sendNewMessage() {
        producerVerifier.send("verify", new Purchase(UUID.randomUUID()));
    }
}
