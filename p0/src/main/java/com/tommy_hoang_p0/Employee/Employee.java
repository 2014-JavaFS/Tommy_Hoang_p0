package com.tommy_hoang_p0.Employee;

public class Employee {
     private final int employeeId;
     private final int roleId;
     //Will enum in the db in which 0 is salesmen and 1 is management.
     private String firstName;
     private String lastName;
     private String email;
     private String phoneNumber;
     private String password;
     public Employee(int employeeId, int roleId, String firstName, String lastName, String email) {
          this.employeeId = employeeId;
          this.roleId = roleId;
          this.firstName = firstName;
          this.lastName = lastName;
          this.email = email;
     }
     public int getEmployeeId() {
          return employeeId;
     }
     public int getRoleId() {
          return roleId;
     }
     public String getFirstName() {
          return firstName;
     }
     public String getLastName() {
          return lastName;
     }
     public String getEmail() {
          return email;
     }
     public String getPhoneNumber() {
          return phoneNumber;
     }
     public String getPassword() {
          return password;
     }
     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }
     public void setLastName(String lastName) {
          this.lastName = lastName;
     }
     public void setEmail(String email) {
          this.email = email;
     }
     public void setPhoneNumber(String phoneNumber) {
          this.phoneNumber = phoneNumber;
     }
     public void setPassword(String password){
          this.password = password; 
     }
     @Override
     public String toString() {
          return "Employee{" +
                  "employeeId=" + employeeId +
                  ", roleId=" + roleId +
                  ", firstName='" + firstName + '\'' +
                  ", lastName='" + lastName + '\'' +
                  ", email='" + email + '\'' +
                  ", phoneNumber='" + phoneNumber + '\'' +
                  ", password='" + password + '\'' +
                  '}';
     }
}
