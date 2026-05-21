package dev.ybendris.order_service.controller;

import dev.ybendris.events.OrderCreatedEvent;
import dev.ybendris.order_service.service.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {
    private final OrderProducer orderProducer;

    @Override
    public ResponseEntity<Void> createOrder(String customerId, BigDecimal amount) {

        OrderCreatedEvent event = OrderCreatedEvent.newBuilder()
                .setOrderId("ORD-123")
                .setCustomerId("CUST-456")
                .setAmount(99.99)
                .setCreatedAt(Instant.now())
                .build();

        orderProducer.send(event);

        return ResponseEntity.ok().build();
    }
}
