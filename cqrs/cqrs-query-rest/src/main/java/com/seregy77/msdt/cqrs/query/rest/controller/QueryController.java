package com.seregy77.msdt.cqrs.query.rest.controller;

import com.seregy77.msdt.cqrs.domain.Ticket;
import com.seregy77.msdt.cqrs.query.rest.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class QueryController {
    private final QueryService queryService;

    @GetMapping("/")
    public List<Ticket> getAllTickets() {
        return queryService.getAllTickets();
    }

    @GetMapping("/available")
    public List<Ticket> getAvailableTickets() {
        return queryService.getAvailableTickets();
    }
}
