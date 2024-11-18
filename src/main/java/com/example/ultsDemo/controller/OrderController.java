package com.example.ultsDemo.controller;

import com.example.ultsDemo.entity.Order;
import com.example.ultsDemo.service.OrderService;
import com.example.ultsDemo.util.OrderStatus;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@Validated
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping
  public ResponseEntity<Order> createOrder(@Valid @RequestBody Order orderRequest){
    if(orderRequest.getItems() == null || orderRequest.getItems().isEmpty()){
      return ResponseEntity.badRequest().body(null);
    }
   orderRequest.setOrderNumber(UUID.randomUUID().toString());
    orderRequest.setStatus(OrderStatus.CREATED);
    orderRequest.setCreatedAt(LocalDateTime.now());
    orderRequest.setTotalAmount(orderRequest.getItems()
    .stream()
    .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
        .reduce(BigDecimal.ZERO,BigDecimal::add));
    Order createdOrder = orderService.saveOrder(orderRequest);
        return ResponseEntity.status(201).body(createdOrder);
  }
}