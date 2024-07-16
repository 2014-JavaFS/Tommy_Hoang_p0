package com.tommy_hoang_p0.Inventory;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tommy_hoang_p0.Util.Interfaces.Crudable;
public class InventoryRepository implements Crudable<Inventory>{
     private static final Logger logger = LoggerFactory.getLogger(InventoryRepository.class);

     @Override
     public boolean update(Inventory inventory) {
          // Implementation logic goes here
          logger.info("Updating inventory item: {}", inventory);
          return false;
     }
     @Override
     public boolean delete(Inventory inventory) {
          // Implementation logic goes here
          logger.info("Deleting inventory item: {}", inventory);
          return false;
     }
     @Override
     public List<Inventory> findAll(){
          return List.of();
     }
     @Override
     public Inventory create(Inventory inventory) {
          // Implementation logic goes here
          logger.info("Creating new inventory item: {}", inventory);
          return null;
     }
     @Override
     public Inventory findById(int number) {
        return null;
    }
}
