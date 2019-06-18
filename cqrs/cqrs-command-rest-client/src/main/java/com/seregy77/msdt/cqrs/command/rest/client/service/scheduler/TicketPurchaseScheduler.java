package com.seregy77.msdt.cqrs.command.rest.client.service.scheduler;

import com.seregy77.msdt.cqrs.command.rest.client.service.TicketPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TicketPurchaseScheduler {
    private final TicketPurchaseService ticketPurchaseService;

    @Scheduled(fixedRate = 5 * 1000)
    public void sendNewMessage() {
        ticketPurchaseService.purchaseTicket(UUID.randomUUID().toString());
    }
}

