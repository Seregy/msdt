package com.seregy77.msdt.cqrs.command.consumer.service;

import com.seregy77.msdt.cqrs.command.consumer.entity.OrderEntity;
import com.seregy77.msdt.cqrs.command.consumer.repository.OrderRepository;
import com.seregy77.msdt.cqrs.command.consumer.repository.TicketRepository;
import com.seregy77.msdt.cqrs.domain.command.PurchaseTicketCommand;
import com.seregy77.msdt.cqrs.entity.TicketEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommandConsumer {
    private static final String TOPIC = "purchase";
    private static final String GROUP_ID = "initial";

    private final TicketRepository ticketRepository;
    private final OrderRepository orderRepository;

    @Transactional
    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void processPurchasedTicket(ConsumerRecord<String, PurchaseTicketCommand> record) {
        log.info("{} [{}-{}] | Received message: {}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), record.topic(), record.partition(), record.value());

        TicketEntity newTicket = createOrUpdateTicket(record);
        createOrder(newTicket);
    }

    private TicketEntity createOrUpdateTicket(ConsumerRecord<String, PurchaseTicketCommand> record) {
        TicketEntity ticketEntity = findOrCreateTicket(record.value().getTicketId());
        return ticketRepository.save(ticketEntity);
    }

    private TicketEntity findOrCreateTicket(long externalId) {
        Optional<TicketEntity> ticketEntityOptional = ticketRepository.findByExternalId(externalId);
        if (ticketEntityOptional.isPresent()) {
            TicketEntity ticketEntity = ticketEntityOptional.get();
            return updateTicketAvailability(ticketEntity);
        }

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setExternalId(externalId);
        return updateTicketAvailability(ticketEntity);
    }

    private TicketEntity updateTicketAvailability(TicketEntity ticketEntity) {
        ticketEntity.setAvailable(false);
        return ticketRepository.save(ticketEntity);
    }

    private OrderEntity createOrder(TicketEntity ticketEntity) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTicket(ticketEntity);
        return orderRepository.save(orderEntity);
    }
}
