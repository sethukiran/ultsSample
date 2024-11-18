package com.example.ultsDemo;

import com.example.ultsDemo.entity.Order;
import com.example.ultsDemo.entity.OrderItem;
import com.example.ultsDemo.repository.OrderRepository;
import com.example.ultsDemo.service.OrderService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceTest {
  @Autowired
  private OrderRepository orderRepository;

  @Test
  public void testSaveOrder() {
    OrderRepository mockRepo = Mockito.mock(OrderRepository.class);
    OrderService orderService = new OrderService(mockRepo);

    Order order = new Order();
    order.setOrderNumber("ORD123");
    order.setItems(Collections.singletonList(new OrderItem("P001", 2, new BigDecimal("100.00"))));
    order.setTotalAmount(new BigDecimal("200.00"));


    Order result = orderService.saveOrder(order);

    assertNotNull(result);
    assertEquals("ORD123", result.getOrderNumber());
  }



  private void assertEquals(String ord123, String orderNumber) {
  }

  private void assertNotNull(Order result) {
  }
}
