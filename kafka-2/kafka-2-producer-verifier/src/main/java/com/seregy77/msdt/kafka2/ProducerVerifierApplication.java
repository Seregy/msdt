package com.seregy77.msdt.kafka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProducerVerifierApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerVerifierApplication.class, args);
    }
}
