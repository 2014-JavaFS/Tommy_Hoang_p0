# Tommy_Hoang_p0
Project 0; uses Java, Maven, Postgres, &amp; Javalin

User stories:
     • Dealership Manager:
          ○ I should be able to take inventory of cars between the list of orders and current stock
          ○ I should be able to insert & delete cars from inventory in the database
          ○ I should be able to see and edit employee data such as id, name, and position
     • Salesman:
          ○ I should be able to view & delete from inventory of cars 
          ○ I should be able to order cars for customers or cancel orders
          ○ I should be able to order cars based on customer request
     • Customer
          ○ I should be able to view the inventory of cars to select from
          ○ I should be able to see the car I order with the salesman
     • Restrictions:
          ○ Customers should not be able to interact with the database and will only have read-only access to the inventory and the specific car they ordered from the list of orders
          ○ Salesmen should not be able to view or handle data from the employee data
          ○ Managers should be able to view and edit all data.
          ○ Salesmen should only be able to edit inventory & orders
     • Requirements:
          ○ Login interface for employees and customers
          ○ Viewing inventory should be available without a login
