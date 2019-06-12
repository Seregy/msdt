package com.seregy77.msdt.cqrs.command.consumer.repository;

import com.seregy77.msdt.cqrs.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    Optional<TicketEntity> findByExternalId(long externalId);
}
