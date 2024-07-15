package com.tommy_hoang_p0.Inventory.Orders;

public class Order {
     private int id_order;
     private String make;
     private String model;
     private String year;
     private String color;
     private String trim;
     private short quantity;
     public Order(String make, String model, String year, short quantity, String trim, String color) {
          this.make = make;
          this.model = model;
          this.year = year;
          this.color = color;
          this.trim = trim;
          this.quantity = quantity;
     }
     public int getId() {
          return id_order;
     }
     public String getMake() {
          return make;
     }
     public String getModel() {
          return model;
     }
     public String getYear() {
          return year;
     }
     public String getColor() {
          return color;
     }
     public String getTrim() {
          return trim;
     }
     public short getQuantity() {
          return quantity;
     }
     public void setId(int id_order) {
          this.id_order = id_order;
     }
     public void setMake(String make) {
          this.make = make;
     }
     public void setModel(String model) {
          this.model = model;
     }
     public void setYear(String year) {
          this.year = year;
     }
     public void setColor(String color) {
          this.color = color;
     }
     public void setTrim(String trim) {
          this.trim = trim;
     }
     public void setQuantity(short quantity) {
          this.quantity = quantity;
     }
     
     @Override
     public String toString() {
          return "Order{" +
                  "id_order=" + id_order +
                  ", make='" + make + '\'' +
                  ", model='" + model + '\'' +
                  ", year='" + year + '\'' +
                  ", color='" + color + '\'' +
                  ", trim='" + trim + '\'' +
                  ", quantity=" + quantity +
                  '}';
     }
}
