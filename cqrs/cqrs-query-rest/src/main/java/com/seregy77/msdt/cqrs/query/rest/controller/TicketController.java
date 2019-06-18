package com.seregy77.msdt.cqrs.query.rest.controller;

import com.seregy77.msdt.cqrs.domain.Ticket;
import com.seregy77.msdt.cqrs.query.rest.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/available")
    public List<Ticket> getAvailableTickets() {
        return ticketService.getAvailableTickets();
    }
}
