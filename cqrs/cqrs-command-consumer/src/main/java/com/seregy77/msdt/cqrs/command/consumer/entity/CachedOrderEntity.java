package com.seregy77.msdt.cqrs.command.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("ticket-order")
@Data
@AllArgsConstructor
public class CachedOrderEntity {
    @Id
    private String ticketId;
}
