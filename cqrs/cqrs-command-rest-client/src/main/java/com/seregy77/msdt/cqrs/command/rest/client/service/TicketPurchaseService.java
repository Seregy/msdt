package com.seregy77.msdt.cqrs.command.rest.client.service;

import com.seregy77.msdt.cqrs.domain.command.PurchaseTicketCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketPurchaseService {
    @Value("${rest_url:http://localhost:8190}")
    private String URL;

    private final RestTemplate restTemplate = new RestTemplate();

    public void purchaseTicket(long id) {
        log.info("{} | Send request for purchasing ticket {}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), id);
        restTemplate.postForEntity(URL + "/ticket/purchased/", new PurchaseTicketCommand(id), Void.class);
    }
}
