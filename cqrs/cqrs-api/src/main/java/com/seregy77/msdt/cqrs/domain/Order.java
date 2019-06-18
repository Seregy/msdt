package com.seregy77.msdt.cqrs.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class Order implements Serializable {
    private final String ticketId;
    private final OffsetDateTime creationTimestamp;

    @JsonCreator
    public Order(@JsonProperty("id") String ticketId,
                 @JsonProperty("creationTimestamp") OffsetDateTime creationTimestamp) {
        this.ticketId = ticketId;
        this.creationTimestamp = creationTimestamp;
    }
}

