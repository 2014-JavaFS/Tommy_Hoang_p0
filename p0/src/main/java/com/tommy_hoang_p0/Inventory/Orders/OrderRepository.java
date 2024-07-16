package com.tommy_hoang_p0.Inventory.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tommy_hoang_p0.Util.ConnectionFactory;
import com.tommy_hoang_p0.Util.Interfaces.Crudable;

public class OrderRepository implements Crudable<Order>{
     private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

     @Override
     public boolean update(Order order){
          // Placeholder for actual database update.
          logger.info("Updating order: {}", order);
          return false;
     }  
     
     @Override
     public boolean delete(Order order){
          // Placeholder for actual database deletion.
          logger.info("Deleting order: {}", order);
          return false;
     }  
     @Override
     public List<Order> findAll(){
          return List.of();
     }

     @Override
     public Order create(Order order){
          // Placeholder for actual database insertion.
          logger.info("Creating order: {}", order);
          return null;
     } 

     @Override
     public Order findById(int id){
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
               String sql = "select * from orders where order_number = ?";
               PreparedStatement pst = conn.prepareStatement(sql);
               pst.setInt(1, id);
               try(ResultSet rs = pst.executeQuery()){
                    if(!rs.next()){
                         throw new RuntimeException("No order found with the given ID.");
                    }
               
               Order order = new Order();
               order.setOrderId(rs.getInt("order_number"));
               //order.setVehicleDetails(); Probably need to make a second query
               order.setCustomer_name(rs.getString("customer_name"));
               order.setCustomer_phone(rs.getString("phone"));
               order.setCustomer_email(rs.getString("email"));
               if(rs.getShort("quantity") > 1){
                    order.setQuantity(rs.getShort("quantity"));
               }

               return order;
               }
          } catch(SQLException e){
               logger.error("Error retrieving order by ID: {}", id, e);
               return null;
          }
     }
}
