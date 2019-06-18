package com.seregy77.msdt.cqrs.query.rest.service;

import com.seregy77.msdt.cqrs.domain.Order;
import com.seregy77.msdt.cqrs.query.rest.mapper.OrderMapper;
import com.seregy77.msdt.cqrs.query.rest.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Cacheable("orders")
    public List<Order> getOrders() {
        log.info("Getting orders from the DB");

        return orderRepository.findAll().stream()
                .map(orderMapper::mapToOrder)
                .collect(Collectors.toList());
    }
}
