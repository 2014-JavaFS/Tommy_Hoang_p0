package com.tommy_hoang_p0;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int choice = 0;
            do {
                System.out.println("\n*************** WELCOME ***************");
                System.out.println(" 1.   Log In as Associate");
                System.out.println(" 2.   Log In as Client");
                System.out.println(" 3.   Register");
                System.out.println(" 4.   View Inventory");
                System.out.println(" 5.   Exit");
                System.out.println("***************************************\n");
                if(!scn.hasNextInt()){
                    System.out.println("Invalid input, please refer to the numerical values listed above.");
                    scn.nextLine();
                    continue;
                }
                choice = scn.nextInt();
                switch(choice){
                    case 1:
                        //TODO: Create a login that differentiates itself from clients
                        System.out.println("\nClient Login");

                        break;
                    case 2:
                        //TODO: Create a login that differentiates itself from associates
                        System.out.println("\nAssociate Login\nPlease enter your Employee ID and Password\nEmployee ID: ");

                        break;
                    case 3:
                        //TODO: Register as a new client
                        System.out.println("\nRegistration");

                        break;
                    case 4:
                        //TODO: Anyone can view the inventory
                        System.out.println("\nInventory");

                        break;
                    case 5:
                        System.out.println("Thank you for using our inventory management system. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid input, please refer to the numerical values listed above.");
                }
            } while (choice != 5);
        }
    }
}