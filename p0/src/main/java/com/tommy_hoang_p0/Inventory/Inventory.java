package com.tommy_hoang_p0.Inventory;

public class Inventory {
     private int car_id;
     private VehicleDetails vehicleDetails;
     private short quantity;

     public Inventory(){}

     public Inventory(int car_id, VehicleDetails vehicleDetails, short quantity) {
          this.car_id = car_id;
          this.vehicleDetails = vehicleDetails;
          this.quantity = quantity;
     }

     public int getId() {
          return car_id;
     }
     public void setId(int car_id) {
          this.car_id = car_id;
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
     
}
