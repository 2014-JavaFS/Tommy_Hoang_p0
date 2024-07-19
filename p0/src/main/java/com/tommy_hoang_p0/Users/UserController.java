package com.tommy_hoang_p0.Users;



import com.tommy_hoang_p0.Util.Exceptions.DataNotFoundException;
import com.tommy_hoang_p0.Util.Interfaces.Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController implements Controller {
     private final UserService userService;

     public UserController(UserService userService) {
          this.userService = userService;
     }

     @Override
     public void registerPaths(Javalin app) {
          app.post("/admin/employees", this::createEmployee);
          app.get("/admin/employees", this::getAllEmployees);
          app.get("/admin/employees/{id}", this::getUserById);
          app.put("/admin/employees/{id}", this::updateEmployee);
          app.delete("/admin/employees/{id}", this::deleteEmployee);

          app.post("/register", this::registerCustomer);
          app.get("/customer/{id}", this::getCustomerById);
          app.put("/customer/{id}", this::updateCustomer);
     }

     private boolean isAdmin(Context ctx) {
          String userType = ctx.header("userType");
          return "ADMIN".equals(userType);
     }
     private boolean isEmployee(Context ctx) {
          String userType = ctx.header("userType");
          return "EMPLOYEE".equals(userType);
     }

     private void createEmployee(Context ctx) {
          if (!isAdmin(ctx)) {
               ctx.status(403).result("FORBIDDEN: Admin access only.");
               return;
          }
          User user = ctx.bodyAsClass(User.class);
          user.setType("EMPLOYEE");
          User newUser = userService.create(user);
          ctx.status(201).json(newUser);
     }
     private void getAllEmployees(Context ctx) {
          if (!isAdmin(ctx)) {
               ctx.status(403).result("FORBIDDEN: Admin access only.");
               return;
          }
          try {
               ctx.json(userService.findAll());
          } catch (DataNotFoundException e) {
               ctx.status(404).result("List of Employees failed to be found.");
          }
     }
     private void getUserById(Context ctx) {
          if (!isAdmin(ctx)) {
               ctx.status(403).result("FORBIDDEN: Admin access only.");
               return;
          }
          int userId = Integer.parseInt(ctx.pathParam("id"));
          try{
               User user = userService.findById(userId);
               ctx.header("id", String.valueOf(user.getUserId()));
               ctx.status(200).json(user);
          } catch (DataNotFoundException e) {
               ctx.status(404).result("User not found.");
          }
     }
     private void updateEmployee(Context ctx) {
          if (!isAdmin(ctx)) {
               ctx.status(403).result("FORBIDDEN: Admin access only.");
               return;
          }
          
          try {
               User updatedUser = ctx.bodyAsClass(User.class);
               int userId = Integer.parseInt(ctx.pathParam("id"));
               updatedUser.setUserId(userId);
               updatedUser.setType("EMPLOYEE");
               if (!userService.update(updatedUser)) {
                    throw new DataNotFoundException("User with id " + userId + " not found.");
               }
               ctx.status(200).json(updatedUser);
          } catch (DataNotFoundException e) {
               ctx.status(404).result(e.getMessage());
          } catch (NumberFormatException e) {
               ctx.status(400).result("Invalid user ID format.");
          }
     }
     private void deleteEmployee(Context ctx) {
          if (!isAdmin(ctx)) {
               ctx.status(403).result("FORBIDDEN: Admin access only.");
               return;
          }
          int userId = Integer.parseInt(ctx.pathParam("id"));
          if(!userService.delete(userId)) throw new DataNotFoundException("User with id " + userId + " not found.");
          ctx.status(204);
     }

     
     private void registerCustomer(Context ctx) {
          if (!isEmployee(ctx)) {
               ctx.status(403).result("FORBIDDEN: Employee access only.");
               return;
          }
          User user = ctx.bodyAsClass(User.class);
          user.setType("CUSTOMER");
          User newUser = userService.create(user);
          ctx.status(201).json(newUser);
     }
     private void getCustomerById(Context ctx) {
          if (!isEmployee(ctx)) {
               ctx.status(403).result("FORBIDDEN: Employee access only.");
               return;
          }
          int userId = Integer.parseInt(ctx.pathParam("id"));
          try{
               User user = userService.findById(userId);
               ctx.header("id", String.valueOf(user.getUserId()));
               ctx.status(200).json(user);
          } catch (Exception e) {
               ctx.status(404).result("User not found.");
          }
     }
     private void updateCustomer(Context ctx) {
          if (!isEmployee(ctx)) {
               ctx.status(403).result("FORBIDDEN: Employee access only.");
               return;
          }
          User updatedUser = ctx.bodyAsClass(User.class);
          updatedUser.setUserId(Integer.parseInt(ctx.pathParam("id")));
          updatedUser.setType("CUSTOMER");
          if (!userService.update(updatedUser)) throw new DataNotFoundException("User with id " + updatedUser.getUserId() + " not found.");
          ctx.status(200).json(updatedUser);
     }
}
