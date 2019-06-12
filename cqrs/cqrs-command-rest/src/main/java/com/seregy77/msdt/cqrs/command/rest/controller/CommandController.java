package com.seregy77.msdt.cqrs.command.rest.controller;

import com.seregy77.msdt.cqrs.command.rest.service.CommandService;
import com.seregy77.msdt.cqrs.domain.command.PurchaseTicketCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class CommandController {
    private final CommandService commandService;

    @PostMapping("/purchased")
    public ResponseEntity<Void> purchaseTicket(@RequestBody PurchaseTicketCommand purchaseTicketCommand) {
        commandService.send(purchaseTicketCommand);
        return ResponseEntity.noContent().build();
    }
}
