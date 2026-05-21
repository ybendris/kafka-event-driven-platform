package dev.ybendris.order_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@RequestMapping("/orders")
public interface OrderController {

    @PostMapping
    ResponseEntity<Void> createOrder(@RequestParam String customerId, @RequestParam BigDecimal amount);
}
