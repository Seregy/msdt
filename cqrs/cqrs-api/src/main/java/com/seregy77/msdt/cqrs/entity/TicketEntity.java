package com.seregy77.msdt.cqrs.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.UUID;

@Data
@Entity(name = "ticket")
public class TicketEntity {
    @Id
    @Column(name = "ticket_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
    @SequenceGenerator(name = "ticket_generator", sequenceName = "ticket_sequence")
    private Long id;
    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;
    @Column(name = "available", nullable = false)
    private boolean available;
}
