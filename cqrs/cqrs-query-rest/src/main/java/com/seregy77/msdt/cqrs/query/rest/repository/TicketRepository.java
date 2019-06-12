package com.seregy77.msdt.cqrs.query.rest.repository;

import com.seregy77.msdt.cqrs.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findAllByAvailableTrue();
}
