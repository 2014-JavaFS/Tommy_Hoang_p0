package com.tommy_hoang_p0.Inventory.Orders;

public class OrderController {
     private final OrderService orderService;

     public OrderController(OrderService orderService) {
          this.orderService = orderService;
     }
     
     public Order findById(int id) {
         return orderService.findById(id);
     }
}
