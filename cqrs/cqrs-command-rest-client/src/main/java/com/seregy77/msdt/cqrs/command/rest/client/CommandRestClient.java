package com.seregy77.msdt.cqrs.command.rest.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CommandRestClient {
    public static void main(String[] args) {
        SpringApplication.run(CommandRestClient.class, args);
    }
}
