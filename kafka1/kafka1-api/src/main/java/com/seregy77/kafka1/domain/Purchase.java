package com.seregy77.kafka1.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class Purchase {
    private final UUID id;
    private boolean verified;

    public Purchase(UUID id) {
        this(id, false);
    }

    @JsonCreator
    public Purchase(@JsonProperty("id") UUID id, @JsonProperty("verified") boolean verified) {
        this.id = id;
        this.verified = verified;
    }
}
