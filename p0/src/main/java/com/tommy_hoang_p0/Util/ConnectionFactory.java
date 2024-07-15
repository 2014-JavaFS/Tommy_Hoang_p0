package com.tommy_hoang_p0.Util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionFactory {
     private static final Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);
     private static ConnectionFactory connectionFactory = new ConnectionFactory();
     private Properties properties = new Properties();

     private ConnectionFactory() {
          try {
              properties.load(new FileReader("p0/src/main/resources/db.properties"));
          } catch (IOException e) {
               logger.error("Error loading database properties", e);
          }
     }

     static{
          try {
              Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException e) {
               logger.error("Error loading PostgreSQL JDBC driver", e);
          }
     }

     public static ConnectionFactory getConnectionFactory() {
          return connectionFactory;
     }

     public Connection getConnection(){
          try {
              return DriverManager.getConnection(properties.getProperty("url"), 
                     properties.getProperty("username"), 
                     properties.getProperty("password"));
          } catch (SQLException e) {
               logger.error("Error connecting to database", e);
               return null;
          }
     }
}
