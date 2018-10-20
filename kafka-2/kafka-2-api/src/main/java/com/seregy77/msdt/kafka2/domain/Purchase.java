package com.seregy77.msdt.kafka2.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class Purchase {
    private final UUID id;

    @JsonCreator
    public Purchase(@JsonProperty("id") UUID id) {
        this.id = id;
    }
}
