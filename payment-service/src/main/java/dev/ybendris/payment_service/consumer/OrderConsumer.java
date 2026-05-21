package dev.ybendris.payment_service.consumer;

import dev.ybendris.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderConsumer {

    @KafkaListener(topics = "orders.created", groupId = "payment-service")
    public void consume(OrderCreatedEvent event) {
        log.info("Order received: {}", event);
    }
}
