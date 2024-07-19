package com.tommy_hoang_p0.Inventory.Orders;

import java.util.List;

import com.tommy_hoang_p0.Util.Exceptions.DataNotFoundException;
 import com.tommy_hoang_p0.Util.Exceptions.InvalidInputException;
import com.tommy_hoang_p0.Util.Interfaces.Serviceable;

public class OrderService implements Serviceable<Order>  {
     private final OrderRepo orderRepository;
     
     public OrderService(OrderRepo orderRepository) {
          this.orderRepository = orderRepository;
     }
     @Override
     public List<Order> findAll() {
          List<Order> orders = orderRepository.findAll();
          if(orders.isEmpty()) throw new DataNotFoundException("No orders found");
          return orderRepository.findAll();
     }
     @Override
     public Order create(Order order) {
          return orderRepository.create(order);
     }
     @Override
     public Order findById(int orderId) {
          return orderRepository.findById(orderId);
     }

     public boolean update(Order order) throws InvalidInputException {
          return orderRepository.update(order);
     }
     
}
