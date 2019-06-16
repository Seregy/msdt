package com.seregy77.msdt.cqrs.domain.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseTicketCommand {
    private UUID ticketId;
}
