package com.seregy77.msdt.kafka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProducerLoggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerLoggerApplication.class, args);
    }
}
