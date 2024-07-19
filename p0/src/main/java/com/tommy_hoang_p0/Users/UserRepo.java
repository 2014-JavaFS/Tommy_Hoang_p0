package com.tommy_hoang_p0.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tommy_hoang_p0.Util.ConnectionFactory;
import com.tommy_hoang_p0.Util.Exceptions.DataNotFoundException;
import com.tommy_hoang_p0.Util.Interfaces.Crudable;

public class UserRepo implements Crudable<User> {
     private static final Logger logger = LoggerFactory.getLogger(UserRepo.class);

     @Override
     public User create(User user) {
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
               String sql = "INSERT INTO tommy_hoang_p0.p0_users (user_type, first_name, last_name, email, phone, pwd) VALUES (?,?,?,?,?,?) RETURNING user_id";
               PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               
               pst.setObject(1, user.getType(), Types.OTHER);
               pst.setString(2, user.getFirstName());
               pst.setString(3, user.getLastName());
               pst.setString(4, user.getEmail());
               pst.setString(5, user.getPhone());
               pst.setString(6, user.getPassword());
               int inserted = pst.executeUpdate();
               ResultSet rs = pst.getGeneratedKeys();
               if (inserted == 0 || !rs.next())   throw new DataNotFoundException("Something went wrong while creating user.");
               return user;
          } catch(SQLException sqlException) {
               logger.error("Error creating user", sqlException);
               return null;
          }
     }
     @Override
     public boolean update(User user) {
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
               String sql = "UPDATE tommy_hoang_p0.p0_users SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE user_id = ?";
               PreparedStatement pst = conn.prepareStatement(sql);
               pst.setString(1, user.getFirstName());
               pst.setString(2, user.getLastName());
               pst.setString(3, user.getEmail());
               pst.setString(4, user.getPhone());
               pst.setInt(5, user.getUserId());
               int updated = pst.executeUpdate();
               
               if (updated == 0) throw new DataNotFoundException("User with id " + user.getUserId() + " not found.");
               return true;
          } catch (SQLException sqlException) {
               logger.error("Error updating user", sqlException);
               return false;
          }
     }
     @Override
     public boolean delete(int id) {
          try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String sql = "DELETE FROM tommy_hoang_p0.p0_users WHERE user_id = ?";
               PreparedStatement pst = conn.prepareStatement(sql);
               pst.setInt(1, id);
               int deleted = pst.executeUpdate();
               if (deleted == 0)   throw new DataNotFoundException("User with id " + id + " not found.");
               return true;
          } catch (SQLException e) {
               logger.error("Error deleting user", e);
               return false;
          }
     }

     @Override
     public List<User> findAll() {
          try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String sql = "SELECT * FROM tommy_hoang_p0.p0_users WHERE user_type != 'CUSTOMER'";
               ResultSet rs = conn.createStatement().executeQuery(sql);
               List<User> users = new ArrayList<>();
               while (rs.next()) {
                    User user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setType(rs.getObject("user_type").toString());
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getString("phone"));
                    users.add(user);
               }
               return users;
          } catch (SQLException e) {
               logger.error("Error finding all users", e);
               return null;
          }
     }

     @Override
     public User findById(int id) {
          try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String sql = "SELECT * FROM tommy_hoang_p0.p0_users WHERE user_id = ?";
               try (PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setInt(1, id);

                    try (ResultSet rs = pst.executeQuery()) {
                         if (!rs.next()) {
                              return null;
                         }

                         User user = new User();
                         user.setUserId(rs.getInt("user_id"));
                         user.setType(rs.getObject("user_type").toString());
                         user.setFirstName(rs.getString("first_name"));
                         user.setLastName(rs.getString("last_name"));
                         user.setEmail(rs.getString("email"));
                         user.setPhone(rs.getString("phone"));
                         return user;
                    }
               }
          } catch (SQLException e) {
               logger.error("Error finding user by id", e);
               return null;
          }
     }

     public User login(String email, String password) {
          try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String sql = "SELECT * FROM tommy_hoang_p0.p0_users WHERE email = ? AND pwd = ?";
               try (PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setString(1, email);
                    pst.setString(2, password);

                    try (ResultSet rs = pst.executeQuery()) {
                         if (!rs.next()) {
                              return null;
                         }

                         User user = new User();
                         user.setUserId(rs.getInt("user_id"));
                         user.setType(rs.getObject("user_type").toString());
                         return user;
                    }
               }
          } catch (SQLException e) {
               logger.error("Error finding user by email and password", e);
               return null;
          }
     }

}
