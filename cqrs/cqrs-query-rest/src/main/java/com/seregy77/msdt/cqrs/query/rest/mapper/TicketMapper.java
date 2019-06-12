package com.seregy77.msdt.cqrs.query.rest.mapper;

import com.seregy77.msdt.cqrs.domain.Ticket;
import com.seregy77.msdt.cqrs.entity.TicketEntity;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public Ticket mapToTicket(TicketEntity ticketEntity) {
        return new Ticket(ticketEntity.getExternalId());
    }
}
