package com.seregy77.msdt.cqrs.query.rest.service;

import com.seregy77.msdt.cqrs.domain.Order;
import com.seregy77.msdt.cqrs.domain.Ticket;
import com.seregy77.msdt.cqrs.query.rest.mapper.OrderMapper;
import com.seregy77.msdt.cqrs.query.rest.mapper.TicketMapper;
import com.seregy77.msdt.cqrs.query.rest.repository.OrderRepository;
import com.seregy77.msdt.cqrs.query.rest.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {
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
