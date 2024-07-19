package com.tommy_hoang_p0.Inventory.Orders;

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
import com.tommy_hoang_p0.Inventory.VehicleDetails;
import com.tommy_hoang_p0.Util.ConnectionFactory;
import com.tommy_hoang_p0.Util.Exceptions.DataNotFoundException;
import com.tommy_hoang_p0.Util.Interfaces.Crudable;

public class OrderRepo implements Crudable<Order>{
     private static final Logger logger = LoggerFactory.getLogger(OrderRepo.class);
     @Override
     public Order create(Order order) {
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
               String sql = "INSERT INTO tommy_hoang_p0.p0_orders (vehicle_details, customer_name, customer_phone, customer_email, quantity) VALUES (?::jsonb,?,?,?,?) RETURNING order_id";
               PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ObjectMapper objectMapper = new ObjectMapper();
               String jsonString = objectMapper.writeValueAsString(order.getVehicleDetails());

               pst.setString(1, jsonString);
               pst.setString(2, order.getCustomer_name());
               pst.setString(3, order.getCustomer_phone());
               pst.setString(4, order.getCustomer_email());
               pst.setShort(5, order.getQuantity());
               int inserted = pst.executeUpdate();
               ResultSet rs = pst.getGeneratedKeys();
               if(inserted == 0 ||!rs.next()) throw new DataNotFoundException("Failed to create order.");
               order.setOrderId(rs.getInt("order_id"));
               return order;
          } catch(SQLException | JsonProcessingException e){
               logger.error("Error creating order", e);
               return null;
          }
     }
     @Override
     public boolean delete(int id) {
          return false;
     }
     @Override
     public boolean update(Order order) {
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
               String sql = "UPDATE tommy_hoang_p0.p0_orders SET vehicle_details = ?::jsonb, customer_name = ?, customer_phone = ?, customer_email = ?, quantity = ? WHERE order_id = ?";
               try(PreparedStatement pst = conn.prepareStatement(sql)){
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonString = objectMapper.writeValueAsString(order.getVehicleDetails());
                    pst.setString(1, jsonString);
                    pst.setString(2, order.getCustomer_name());
                    pst.setString(3, order.getCustomer_phone());
                    pst.setString(4, order.getCustomer_email());
                    pst.setShort(5, order.getQuantity());
                    pst.setInt(6, order.getOrderId());
                    int updated = pst.executeUpdate();
                    return updated > 0;
                }
          } catch (SQLException | JsonProcessingException e) {
               logger.error("Error updating order", e);
               return false;
          }
     }
     @Override
     public List<Order> findAll() {
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
               String sql = "SELECT * FROM tommy_hoang_p0.p0_orders";
               try(PreparedStatement pst = conn.prepareStatement(sql)){
                    List<Order> orders = new ArrayList<>();
                    try(ResultSet rs = pst.executeQuery()){
                         while(rs.next()){
                              ObjectMapper objectMapper = new ObjectMapper();
                              String jsonString = rs.getString("vehicle_details");
                              Order order = new Order();
                              order.setOrderId(rs.getInt("order_id"));
                              order.setVehicleDetails(objectMapper.readValue(jsonString, VehicleDetails.class));
                              order.setCustomer_name(rs.getString("customer_name"));
                              order.setCustomer_phone(rs.getString("customer_phone"));
                              order.setCustomer_email(rs.getString("customer_email"));
                              order.setQuantity(rs.getShort("quantity"));
                              orders.add(order);
                         }
                         return orders;
                    }
               }
          } catch (SQLException | JsonProcessingException e) {
               logger.error("Error finding all orders", e);
               return null;
          }
     }
     @Override
     public Order findById(int id) {
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
               String sql = "SELECT * FROM tommy_hoang_p0.p0_orders WHERE order_id = ?";
               try(PreparedStatement pst = conn.prepareStatement(sql)){
                    pst.setInt(1, id);

                    try(ResultSet rs = pst.executeQuery()){
                         if(!rs.next()){
                              throw new DataNotFoundException("No order found with the given id.");
                         }

                         ObjectMapper objectMapper = new ObjectMapper();
                         String jsonString = rs.getString("vehicle_details");

                         Order order = new Order();
                         order.setOrderId(rs.getInt("order_id"));
                         order.setVehicleDetails(objectMapper.readValue(jsonString, VehicleDetails.class));
                         order.setCustomer_name(rs.getString("customer_name"));
                         order.setCustomer_phone(rs.getString("customer_phone"));
                         order.setCustomer_email(rs.getString("customer_email"));
                         order.setQuantity(rs.getShort("quantity"));
                         return order;
                    }
               }
          } catch (SQLException | JsonProcessingException e) {
               logger.error("Error finding car by id", e);
               return null;
          }
     }
}
