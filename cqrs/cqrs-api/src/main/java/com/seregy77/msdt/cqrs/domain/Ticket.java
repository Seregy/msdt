package com.seregy77.msdt.cqrs.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ticket {
    private final long id;

    @JsonCreator
    public Ticket(@JsonProperty("id") long id) {
        this.id = id;
    }
}
