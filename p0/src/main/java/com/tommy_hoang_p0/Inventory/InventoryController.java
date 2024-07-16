package com.tommy_hoang_p0.Inventory;

public class InventoryController {
     private final InventoryService inventoryService;

     public InventoryController(InventoryService inventoryService) {
          this.inventoryService = inventoryService;
     }

     public Inventory findById(int id_inventory) {
          return inventoryService.findById(id_inventory);
     }
}
