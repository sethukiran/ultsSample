package com.example.ultsDemo.service;

import com.example.ultsDemo.entity.Order;
import com.example.ultsDemo.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
  @Autowired
  private OrderRepository orderRepository;

  public OrderService(OrderRepository mockRepo) {
  }


  public Order saveOrder(Order order){
    logger.info("Saving order with order number: {}", order.getOrderNumber());
    order.getItems().forEach(item -> item.setOrder(order));
    Order savedOrder = orderRepository.save(order);
    logger.info("Order saved successfully with ID: {}", savedOrder.getId());
    return savedOrder;
  }
}
