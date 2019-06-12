package com.seregy77.msdt.cqrs.command.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.seregy77.msdt.cqrs")
@SpringBootApplication
public class CommandConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommandConsumerApplication.class, args);
    }
}
