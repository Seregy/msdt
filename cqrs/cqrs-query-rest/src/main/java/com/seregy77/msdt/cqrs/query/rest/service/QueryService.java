package com.seregy77.msdt.cqrs.query.rest.service;

import com.seregy77.msdt.cqrs.domain.Ticket;
import com.seregy77.msdt.cqrs.query.rest.mapper.TicketMapper;
import com.seregy77.msdt.cqrs.query.rest.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public List<Ticket> getAvailableTickets() {
        return ticketRepository.findAllByAvailableTrue().stream()
                .map(ticketMapper::mapToTicket)
                .collect(Collectors.toList());
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(ticketMapper::mapToTicket)
                .collect(Collectors.toList());
    }
}
