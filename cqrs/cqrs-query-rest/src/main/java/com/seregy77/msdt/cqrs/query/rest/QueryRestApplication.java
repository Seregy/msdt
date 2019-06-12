package com.seregy77.msdt.cqrs.query.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.seregy77.msdt.cqrs.entity")
@SpringBootApplication
public class QueryRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(QueryRestApplication.class, args);
    }
}
