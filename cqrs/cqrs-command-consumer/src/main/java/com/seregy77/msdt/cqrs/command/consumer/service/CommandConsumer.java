package com.seregy77.msdt.cqrs.command.consumer.service;

import com.seregy77.msdt.cqrs.entity.OrderEntity;
import com.seregy77.msdt.cqrs.command.consumer.repository.OrderRepository;
import com.seregy77.msdt.cqrs.command.consumer.repository.TicketRepository;
import com.seregy77.msdt.cqrs.domain.command.PurchaseTicketCommand;
import com.seregy77.msdt.cqrs.entity.TicketEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommandConsumer {
    private static final String TOPIC_PURCHASE = "purchase";
    private static final String GROUP_ID = "initial";

    private final TicketRepository ticketRepository;
    private final OrderRepository orderRepository;
    private final OrderCachingService orderCachingService;

    @Transactional
    @KafkaListener(topics = TOPIC_PURCHASE, groupId = GROUP_ID)
    public void processPurchasedTicket(ConsumerRecord<String, PurchaseTicketCommand> record) {
        log.info("{} [{}-{}] | Received message: {}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), record.topic(), record.partition(), record.value());

        String ticketId = record.value().getTicketId();
        if (orderCachingService.isCached(ticketId)) {
            log.info("{} | Ticket with id [{}] is already contained, ignoring the request",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), ticketId);
            return;
        }

        TicketEntity newTicket = createOrUpdateTicket(record);
        createOrder(newTicket);
        orderCachingService.cache(ticketId);
    }

    private TicketEntity createOrUpdateTicket(ConsumerRecord<String, PurchaseTicketCommand> record) {
        TicketEntity ticketEntity = findOrCreateTicket(record.value().getTicketId());
        TicketEntity updatedTicket = updateTicketAvailability(ticketEntity);
        return ticketRepository.save(updatedTicket);
    }

    private TicketEntity findOrCreateTicket(String externalId) {
        Optional<TicketEntity> ticketEntityOptional = ticketRepository.findByExternalId(externalId);
        if (ticketEntityOptional.isPresent()) {
            return ticketEntityOptional.get();
        }

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setExternalId(externalId);
        return ticketEntity;
    }

    private TicketEntity updateTicketAvailability(TicketEntity ticketEntity) {
        ticketEntity.setAvailable(false);
        return ticketRepository.save(ticketEntity);
    }

    private void createOrder(TicketEntity ticketEntity) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTicket(ticketEntity);
        orderRepository.save(orderEntity);
    }
}
