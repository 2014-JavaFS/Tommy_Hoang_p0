package com.tommy_hoang_p0.Inventory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tommy_hoang_p0.Util.Interfaces.Serviceable;

public class InventoryService implements Serviceable<Inventory> {
     private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);
     private final List<Inventory> carList = new ArrayList<>();
     private final InventoryRepository inventoryRepository;

     public InventoryService(InventoryRepository inventoryRepository) {
          this.inventoryRepository = inventoryRepository;
     }

     @Override
     public List<Inventory> findAll() {
          return inventoryRepository.findAll();
     }

     @Override
     public Inventory findById(int id_inventory) {
          logger.info("Member ID was sent to service as {}", id_inventory);

          return inventoryRepository.findById(id_inventory);
     }
     @Override
     public Inventory create(Inventory newInventory) {
          logger.info("New inventory was sent to service: {}", newInventory);
          carList.add(newInventory);
          return newInventory;
     }

     public void update(Inventory updatedInventory) {
          for(int i = 0; i < carList.size(); i++) {
               if(carList.get(i).getId() == updatedInventory.getId()){
                    carList.set(i, updatedInventory);
                    return;
               }
          }
     }
}
