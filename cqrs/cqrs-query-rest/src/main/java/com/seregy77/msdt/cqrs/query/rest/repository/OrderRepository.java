package com.seregy77.msdt.cqrs.query.rest.repository;

import com.seregy77.msdt.cqrs.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
