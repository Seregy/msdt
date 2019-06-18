package com.seregy77.msdt.cqrs.entity;

import com.seregy77.msdt.cqrs.entity.TicketEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.time.OffsetDateTime;

@Data
@Entity(name = "ticket_order")
public class OrderEntity {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_order_generator")
    @SequenceGenerator(name = "ticket_order_generator", sequenceName = "ticket_order_sequence", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private TicketEntity ticket;
    @Column(name = "creation_timestamp", nullable = false)
    private OffsetDateTime creationTimestamp = OffsetDateTime.now();
}
