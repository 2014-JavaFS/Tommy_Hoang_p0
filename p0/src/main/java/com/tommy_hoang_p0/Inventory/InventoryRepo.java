package com.tommy_hoang_p0.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tommy_hoang_p0.Inventory.Orders.Order;
import com.tommy_hoang_p0.Util.ConnectionFactory;
import com.tommy_hoang_p0.Util.Interfaces.Crudable;

public class InventoryRepo implements Crudable<Inventory> {
     private static final Logger logger = LoggerFactory.getLogger(InventoryRepo.class);

     @Override
     public Inventory create(Inventory inventory) {
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
               String sql = "INSERT INTO tommy_hoang_p0.p0_inventory (vehicle_details, quantity) VALUES (?::jsonb,?) RETURNING car_id";
               PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ObjectMapper objectMapper = new ObjectMapper();
               String jsonString = objectMapper.writeValueAsString(inventory.getVehicleDetails());

               pst.setString(1, jsonString);
               pst.setShort(2, inventory.getQuantity());
               int inserted = pst.executeUpdate();
               ResultSet rs = pst.getGeneratedKeys();
               if (inserted == 0 ||!rs.next()) {
                    throw new RuntimeException("Failed to create inventory.");
               }
               inventory.setId(rs.getInt("car_id"));
               return inventory;
          } catch (SQLException | JsonProcessingException e) {
               logger.error("Error inserting into Inventory", e);
               return null;
          }
     }
     public Inventory insertOrder(Inventory inventory) {
          return null;
     }
     @Override
     public boolean update(Inventory inventory) {
          return false;
     }
     @Override
     public boolean delete(int id) {
          try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String selectSql = "SELECT quantity FROM tommy_hoang_p0.p0_inventory WHERE car_id = ?";
               try (PreparedStatement selectPst = conn.prepareStatement(selectSql)) {
                    selectPst.setInt(1, id);
                    ResultSet rs = selectPst.executeQuery();
                    if (rs.next()) {
                         short quantity = rs.getShort("quantity");
                         if (quantity > 1) {
                              String updateSql = "UPDATE tommy_hoang_p0.p0_inventory SET quantity = ? WHERE car_id = ?";
                              try (PreparedStatement updatePst = conn.prepareStatement(updateSql)) {
                                   updatePst.setShort(1, (short) (quantity - 1));  // Decrease quantity by 1
                                   updatePst.setInt(2, id);
                                   int updated = updatePst.executeUpdate();
                                   return updated > 0;
                              }
                         } else {
                              String deleteSql = "DELETE FROM tommy_hoang_p0.p0_inventory WHERE car_id = ?";
                              try (PreparedStatement deletePst = conn.prepareStatement(deleteSql)) {
                              deletePst.setInt(1, id);
                              int deleted = deletePst.executeUpdate();
                              return deleted > 0;
                              }
                         }
                    } else {
                         return false;
                    }
               }
          } catch (SQLException e) {
               logger.error("Error deleting or updating inventory", e);
               return false;
          }
     }



     @Override
     public List<Inventory> findAll() {
          ObjectMapper objectMapper = new ObjectMapper();
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String sql = "SELECT * FROM tommy_hoang_p0.p0_inventory";
               ResultSet rs = conn.createStatement().executeQuery(sql);
               List<Inventory> cars = new ArrayList<>();
               while (rs.next()) {
                    Inventory car = new Inventory();
                    car.setId(rs.getInt("car_id"));
                    String vehicleDetailsJson = rs.getString("vehicle_details");
                    VehicleDetails vehicleDetails = objectMapper.readValue(vehicleDetailsJson, VehicleDetails.class);
                    car.setVehicleDetails(vehicleDetails);
                    car.setQuantity(rs.getShort("quantity"));
                    cars.add(car);
               }
               return cars;
          } catch (SQLException | JsonProcessingException e) {
               logger.error("Error finding all cars in inventory", e);
               return null;
          }
     }
     public List<Object> getInvAndOrders() {
          ObjectMapper objectMapper = new ObjectMapper();
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String sql = "SELECT * FROM tommy_hoang_p0.p0_inventory";
               ResultSet rs = conn.createStatement().executeQuery(sql);
               List<Inventory> cars = new ArrayList<>();
               while (rs.next()) {
                    Inventory car = new Inventory();
                    car.setId(rs.getInt("car_id"));
                    String vehicleDetailsJson = rs.getString("vehicle_details");
                    VehicleDetails vehicleDetails = objectMapper.readValue(vehicleDetailsJson, VehicleDetails.class);
                    car.setVehicleDetails(vehicleDetails);
                    car.setQuantity(rs.getShort("quantity"));
                    cars.add(car);
               }
               String sql2 = "SELECT * FROM tommy_hoang_p0.p0_orders";
               ResultSet rs2 = conn.createStatement().executeQuery(sql2);
               List<Order> orders = new ArrayList<>();
               while(rs2.next()){
                    Order order = new Order();
                    order.setOrderId(rs2.getInt("order_id"));
                    String vehicleDetailsJson = rs2.getString("vehicle_details");
                    VehicleDetails vehicleDetails = objectMapper.readValue(vehicleDetailsJson, VehicleDetails.class);
                    order.setVehicleDetails(vehicleDetails);
                    order.setCustomer_name(rs2.getString("customer_name"));
                    order.setCustomer_phone(rs2.getString("customer_phone"));
                    order.setCustomer_email(rs2.getString("customer_email"));
                    order.setQuantity(rs2.getShort("quantity"));
                    orders.add(order);
               }
               List<Object> lst = new ArrayList<>();
               lst.addAll(cars);
               lst.addAll(orders);
               return lst;
          } catch (SQLException | JsonProcessingException e) {
               logger.error("Error finding all cars in inventory", e);
               return null;
          }
     }
     @Override
     public Inventory findById(int id) {
          try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String sql = "SELECT * FROM tommy_hoang_p0.p0_inventory WHERE id_car = ?";
               try (PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setInt(1, id);

                    try (ResultSet rs = pst.executeQuery()) {
                         if (!rs.next()) {
                              throw new RuntimeException("No car found with the given info.");
                         }

                         ObjectMapper objectMapper = new ObjectMapper();
                         String jsonString = rs.getString("vehicle_details");

                         Inventory car = new Inventory();
                         car.setId(rs.getInt("car_id"));
                         car.setVehicleDetails(objectMapper.readValue(jsonString, VehicleDetails.class));
                         car.setQuantity(rs.getShort("quantity"));
                         return car;
                    }
               }
          } catch (SQLException | JsonProcessingException e) {
               logger.error("Error finding car by id", e);
               return null;
          }
     }
}
