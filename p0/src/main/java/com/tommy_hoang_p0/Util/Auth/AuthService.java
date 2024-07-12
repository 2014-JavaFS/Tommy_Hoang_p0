package com.tommy_hoang_p0.Util.Auth;

import javax.security.sasl.AuthenticationException;

import com.tommy_hoang_p0.Employee.Employee;
import com.tommy_hoang_p0.Employee.EmployeeService;

public class AuthService {
     
     private final EmployeeService employeeService;
     
     public AuthService(EmployeeService employeeService) {
          this.employeeService = employeeService;
     }

     public Employee login(String email, String password) throws AuthenticationException {
          Employee employee = employeeService.findByEmailAndPassword(email, password);
          if(employee == null) throw new AuthenticationException("Invalid email or password.");
          return employee;
     }
     
}
