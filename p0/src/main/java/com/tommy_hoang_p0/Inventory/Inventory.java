package com.tommy_hoang_p0.Inventory;

public class Inventory {
     private int id_inventory;
     private VehicleDetails vehicleDetails;
     private short quantity;

     public Inventory(){}

     public Inventory(int id_inventory, VehicleDetails vehicleDetails, short quantity) {
          this.id_inventory = id_inventory;
          this.vehicleDetails = vehicleDetails;
          this.quantity = quantity;
     }
     public int getId() {
          return id_inventory;
     }
     public void setId(int id_inventory) {
          this.id_inventory = id_inventory;
     }
     
     public VehicleDetails getVehicleDetails() {
          return vehicleDetails;
     }
     public void setVehicleDetails(VehicleDetails vehicleDetails) {
          this.vehicleDetails = vehicleDetails;
     }

     public short getQuantity() {
          return quantity;
     }
     public void setQuantity(short quantity) {
          this.quantity = quantity;
     }
     
     @Override
     public String toString() {
          return "Inventory{" +
                  "id_inventory=" + id_inventory +
                  ", vehicleDetails=" + vehicleDetails +
                  ", quantity=" + quantity +
                  '}';
     }
}
