package com.seregy77.msdt.cqrs.command.consumer.repository;

import com.seregy77.msdt.cqrs.command.consumer.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
