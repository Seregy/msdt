package com.seregy77.msdt.cqrs.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class Ticket {
    private final UUID id;

    @JsonCreator
    public Ticket(@JsonProperty("id") UUID id) {
        this.id = id;
    }
}
