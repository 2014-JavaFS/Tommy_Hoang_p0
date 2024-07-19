package com.tommy_hoang_p0.Inventory;

import com.tommy_hoang_p0.Util.Exceptions.DataNotFoundException;
import com.tommy_hoang_p0.Util.Interfaces.Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class InventoryController implements Controller  {
     private final InventoryService inventoryService;
     public InventoryController(InventoryService inventoryService) {
          this.inventoryService = inventoryService;
     }

     @Override
     public void registerPaths(Javalin app) {
          app.post("/admin/inventory", this::addCar);
          app.get("/inventory", this::getInventory);
          app.get("/admin/inventory", this::getInvAndOrders);
          app.delete("/inventory/{id}", this::deleteInventory);
     }

     private boolean isAdmin(Context ctx) {
          String userType = ctx.header("userType");
          return "ADMIN".equals(userType);
     }
     
     private void addCar(Context ctx) {
     if (!isAdmin(ctx)) {
         ctx.status(403).result("FORBIDDEN: Admin access only.");
         return;
     }
     Inventory car = ctx.bodyAsClass(Inventory.class);
     Inventory newCar = inventoryService.create(car);
     if (newCar == null) {
         ctx.status(500).result("Internal Server Error: Failed to create car.");
     } else {
         ctx.status(201).json(newCar);
     }
 }

     private void getInventory(Context ctx) {
          try {
              ctx.json(inventoryService.findAll());
          } catch (Exception e) {
               ctx.status(500).result("Server Error");
          }
     }

     private void getInvAndOrders(Context ctx) {
          if (!isAdmin(ctx)) {
               ctx.status(403).result("FORBIDDEN: Admin access only.");
               return;
          }
          try{
               ctx.json(inventoryService.getInvAndOrders());
          } catch (Exception e){
               ctx.status(500).result("Server Error");
          }
     }
     
     private void deleteInventory(Context ctx) {
          if (!isAdmin(ctx)) {
               ctx.status(403).result("FORBIDDEN: Admin access only.");
               return;
          }
          int id = Integer.parseInt(ctx.pathParam("id"));
          if(!inventoryService.delete(id)) throw new DataNotFoundException("User with id " + id + " not found.");
          inventoryService.delete(id);
          ctx.status(204);
     }
     
}
