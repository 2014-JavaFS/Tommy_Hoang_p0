package com.tommy_hoang_p0.Inventory.Orders;

import com.tommy_hoang_p0.Util.Exceptions.DataNotFoundException;
import com.tommy_hoang_p0.Util.Interfaces.Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class OrderController implements Controller {
     private final OrderService orderService;
     public OrderController(OrderService orderService) {
          this.orderService = orderService;
     }
     private boolean isAdmin(Context ctx){
          String userType = ctx.header("userType");
          return "ADMIN".equals(userType);
     }
     private boolean isEmployee(Context ctx){
          String userType = ctx.header("userType");
          return "EMPLOYEE".equals(userType);
     }

     @Override
     public void registerPaths(Javalin app) {
          app.post("/orders", this::createOrder);
          app.get("/orders", this::getAllOrders);
          app.get("/orders/{id}", this::getOrderById);
          app.put("/orders/{id}", this::editOrder);
     }

     private void createOrder(Context ctx) {
          if (!isEmployee(ctx)) {
               ctx.status(403).result("FORBIDDEN: Employees Only.");
               return;
          }
          Order order = ctx.bodyAsClass(Order.class);
          orderService.create(order);
          ctx.status(201).result("Order created successfully.");
     }
     private void getAllOrders(Context ctx) {
        if(!isAdmin(ctx) && !isEmployee(ctx)) {
          ctx.status(403).result("FORBIDDEN: Only Admins and Employees.");
          return;
        }
        try {
               ctx.json(orderService.findAll());
        } catch (DataNotFoundException e) {
               ctx.status(404).result("List of Orders not found.");
        }
     }
     private void getOrderById(Context ctx) {
          if (isAdmin(ctx)) {
               ctx.status(403).result("FORBIDDEN: Employees and Customers only.");
               return;
          }
          int orderId = Integer.parseInt(ctx.pathParam("id"));
          try {
               Order order = orderService.findById(orderId);
               ctx.header("id", String.valueOf(order.getOrderId()));
               ctx.status(200).json(order);
          } catch (DataNotFoundException e) {
               ctx.status(404).result("Order not found.");
          }
     }
     private void editOrder(Context ctx) {
          if (isAdmin(ctx)) {
               ctx.status(403).result("FORBIDDEN: Employees and Customers only.");
               return;
          }
          try {
              Order order = ctx.bodyAsClass(Order.class);
              int orderId = Integer.parseInt(ctx.pathParam("id"));
              order.setOrderId(orderId);
              if(!orderService.update(order)){

              }
          } catch (DataNotFoundException e) {
               ctx.status(404).result(e.getMessage());
          } catch (NumberFormatException e) {
               ctx.status(400).result("Invalid order ID.");
          }
     }
}
