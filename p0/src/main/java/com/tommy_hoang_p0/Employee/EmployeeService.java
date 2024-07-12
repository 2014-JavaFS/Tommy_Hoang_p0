package com.tommy_hoang_p0.Employee;

import com.tommy_hoang_p0.Util.Interfaces.*;

import java.util.*;
public class EmployeeService implements Serviceable<Employee> {
     private List<Employee> employeeList = new ArrayList<>();



     


     /**
      * Credential validation for employee login.
      * @param email
      * @param password
      * @return
      */
     public Employee findByEmailAndPassword(String email, String password) {
          for (Employee employee : employeeList) {
               if (employee.getEmail().equals(email) && employee.getPassword().equals(password)) {
                    return employee;
               }
          }
          return null;
     }
}
