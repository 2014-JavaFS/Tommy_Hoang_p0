package com.tommy_hoang_p0.Inventory.Orders;

import java.time.LocalDateTime;

import com.tommy_hoang_p0.Inventory.VehicleDetails;

public class Order {
     private int id_order;
     private VehicleDetails vehicleDetails;
     private String customer_name;
     private String customer_phone;
     private String customer_email;
     private LocalDateTime edit_deadline;
     private LocalDateTime delivery_date;
     private short quantity;

     public Order(){}
     
     public Order(int id_order, VehicleDetails vehicleDetails, String customer_name, String customer_phone, String customer_email) {
          this.id_order = id_order;
          this.vehicleDetails = vehicleDetails;
          this.customer_name = customer_name;
          this.customer_phone = customer_phone;
          this.customer_email = customer_email;
     }
     public int getOrderId() {
          return id_order;
     }
     public void setOrderId(int id_order) {
          this.id_order = id_order;
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

     public LocalDateTime getEdit_deadline() {
          return edit_deadline;
     }
     public void setEdit_deadline(LocalDateTime edit_deadline) {
          this.edit_deadline = edit_deadline;
     }

     public LocalDateTime getDelivery_date() {
          return delivery_date;
     }
     public void setDelivery_date(LocalDateTime delivery_date) {
          this.delivery_date = delivery_date;
     }
     public short getQuantity() {
          return quantity;
     }

     public void setQuantity(short quantity) {
          this.quantity = quantity;
     }

     @Override
     public String toString() {
          return "Order{" +
                  "id_order=" + id_order +
                  ", vehicleDetails=" + vehicleDetails +
                  ", customer_name='" + customer_name + '\'' +
                  ", customer_phone='" + customer_phone + '\'' +
                  ", customer_email='" + customer_email + '\'' +
                  ", edit_deadline=" + edit_deadline +
                  ", delivery_date=" + delivery_date +
                  ", quantity=" + quantity +
                  '}';
     }
    
}
