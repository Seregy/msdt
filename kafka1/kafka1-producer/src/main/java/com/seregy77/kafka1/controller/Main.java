package com.seregy77.kafka1.controller;

import com.seregy77.kafka1.domain.Purchase;
import com.seregy77.kafka1.service.Producer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Controller
public class Main {
    private final Producer producer;

    @PostMapping("topic/{topicName}")
    public ResponseEntity<?> sendToTopic(@PathVariable String topicName, @RequestBody Purchase payload) {
        producer.send(topicName, payload);
        return ResponseEntity.ok().build();
    }
}