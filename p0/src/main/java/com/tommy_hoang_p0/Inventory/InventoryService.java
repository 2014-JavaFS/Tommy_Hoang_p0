package com.tommy_hoang_p0.Inventory;

import java.util.List;

import com.tommy_hoang_p0.Util.Exceptions.InvalidInputException;
import com.tommy_hoang_p0.Util.Interfaces.Serviceable;

public class InventoryService implements Serviceable<Inventory> {
     private final InventoryRepo invRepository;

     public InventoryService(InventoryRepo invRepository) {
          this.invRepository = invRepository;
     }

     @Override
     public List<Inventory> findAll(){
          return invRepository.findAll();
     }

     @Override
     public Inventory findById(int invId) {
          return invRepository.findById(invId);
     }

     @Override
     public Inventory create(Inventory newInv) {
          return invRepository.create(newInv);
     }

     public List<Object> getInvAndOrders(){
          return invRepository.getInvAndOrders();
     }

     public boolean delete(int id) throws InvalidInputException {
          return invRepository.delete(id);
     }
}
