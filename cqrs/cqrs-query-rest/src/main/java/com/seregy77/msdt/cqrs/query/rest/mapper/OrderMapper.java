package com.seregy77.msdt.cqrs.query.rest.mapper;

import com.seregy77.msdt.cqrs.domain.Order;
import com.seregy77.msdt.cqrs.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order mapToOrder(OrderEntity orderEntity) {
        return new Order(orderEntity.getTicket().getExternalId(), orderEntity.getCreationTimestamp());
    }
}
