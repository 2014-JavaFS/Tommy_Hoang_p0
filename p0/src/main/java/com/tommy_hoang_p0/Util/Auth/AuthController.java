package com.tommy_hoang_p0.Util.Auth;

import java.util.Scanner;

import javax.security.sasl.AuthenticationException;

import com.tommy_hoang_p0.Employee.Employee;

public class AuthController {

     private final Scanner scn;
     private final AuthService authService;
     
     public AuthController(Scanner scn, AuthService authService) {
          this.scn = scn;
          this.authService = authService;
     }

     public Employee login(Employee employeeLogin){
          try {
               if(employeeLogin != null) throw new RuntimeException("Already logged in.");
               System.out.print("Email: ");
               String email = scn.next();
               System.out.print("\nPassword: ");
               String password = scn.next();

               return authService.login(email, password);
          } catch (AuthenticationException | RuntimeException e) {
               System.out.println(e.getMessage());
          }
          return employeeLogin;
     }
}
