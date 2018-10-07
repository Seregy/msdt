package com.seregy77.kafka1;

import com.seregy77.kafka1.domain.Purchase;
import com.seregy77.kafka1.service.Producer;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class ScheduledTasks {
    private final Producer producer;

    @Scheduled(fixedRate = 10 * 1000)
    public void sendNewMessage() {
        producer.send("log", new Purchase(UUID.randomUUID()));
    }
}
