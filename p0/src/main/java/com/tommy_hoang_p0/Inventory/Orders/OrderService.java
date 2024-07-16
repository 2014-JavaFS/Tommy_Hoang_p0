package com.tommy_hoang_p0.Inventory.Orders;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tommy_hoang_p0.Util.Interfaces.Serviceable;

public class OrderService implements Serviceable<Order>{
     private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
     private final List<Order> orderList = new ArrayList<>();
     private final OrderRepository orderRepository;

     public OrderService(OrderRepository orderRepository) {
          this.orderRepository = orderRepository;
     }

     @Override
     public List<Order> findAll() {
          logger.info("All orders were requested");
          return orderRepository.findAll();
     }

     @Override
     public Order findById(int id) {
          logger.info("Order ID was sent to service as {}", id);
          return orderRepository.findById(id);
     }

     @Override
     public Order create(Order newOrder) {
          orderList.add(newOrder);
          logger.info("New order created: {}", newOrder);
          return newOrder;
     }

     public void update(Order order) {
          for(int i = 0; i < orderList.size(); i++) {
               if(orderList.get(i).getOrderId() == order.getOrderId()) {
                    orderList.set(i, order);
                    logger.info("Order with ID {} updated: {}", order.getOrderId(), order);
                    return;
               }
          }
     }
}
