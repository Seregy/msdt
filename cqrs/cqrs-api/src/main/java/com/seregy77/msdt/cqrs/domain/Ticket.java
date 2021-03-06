package com.seregy77.msdt.cqrs.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class Ticket implements Serializable {
    private final String id;

    @JsonCreator
    public Ticket(@JsonProperty("id") String id) {
        this.id = id;
    }
}
