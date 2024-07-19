package com.tommy_hoang_p0.Inventory.Orders;

import com.tommy_hoang_p0.Inventory.VehicleDetails;

public class Order {
     private int order_id;
     private VehicleDetails vehicleDetails;
     private String customer_name;
     private String customer_phone;
     private String customer_email;
     private short quantity;
     
     public Order(){}
     public Order(int order_id, VehicleDetails vehicleDetails, String customer_name, String customer_phone, String customer_email, short quantity) {
          this.order_id = order_id;
          this.vehicleDetails = vehicleDetails;
          this.customer_name = customer_name;
          this.customer_phone = customer_phone;
          this.customer_email = customer_email;
          this.quantity = quantity;
     }
     
     public int getOrderId() {
          return order_id;
     }
     public void setOrderId(int order_id) {
          this.order_id = order_id;
     }

     public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
     }
     public void setVehicleDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
     }

     public String getCustomer_name() {
        return customer_name;
     }
     public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
     }

     public String getCustomer_phone() {
        return customer_phone;
     }
     public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
     }

     public String getCustomer_email() {
        return customer_email;
     }
     public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
     }

     public short getQuantity() {
          return quantity;
     }
     public void setQuantity(short quantity) {
          this.quantity = quantity;
     }
    
}
