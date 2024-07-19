package com.tommy_hoang_p0;

import com.tommy_hoang_p0.Inventory.InventoryController;
import com.tommy_hoang_p0.Inventory.InventoryRepo;
import com.tommy_hoang_p0.Inventory.InventoryService;

import com.tommy_hoang_p0.Inventory.Orders.OrderController;
import com.tommy_hoang_p0.Inventory.Orders.OrderRepo;
import com.tommy_hoang_p0.Inventory.Orders.OrderService;

import com.tommy_hoang_p0.Users.UserController;
import com.tommy_hoang_p0.Users.UserRepo;
import com.tommy_hoang_p0.Users.UserService;
import com.tommy_hoang_p0.Util.Auth.AuthController;
import com.tommy_hoang_p0.Util.Auth.AuthService;

 import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dealership Point of Sale is up and running.....");

        Javalin app = Javalin.create(config -> {
            config.jsonMapper(new JavalinJackson());
        });

        InventoryRepo inventoryRepo = new InventoryRepo();
        InventoryService inventoryService = new InventoryService(inventoryRepo);
        InventoryController inventoryController = new InventoryController(inventoryService);
        inventoryController.registerPaths(app);

        OrderRepo orderRepo = new OrderRepo();
        OrderService orderService = new OrderService(orderRepo);
        OrderController orderController = new OrderController(orderService);
        orderController.registerPaths(app);

        UserRepo userRepo = new UserRepo();  
        UserService userService = new UserService(userRepo);
        UserController userController = new UserController(userService);
        userController.registerPaths(app);

        AuthService authService = new AuthService(userService);
        AuthController authController = new AuthController(authService);

        authController.registerPaths(app);

        app.start(8080);
    }
}