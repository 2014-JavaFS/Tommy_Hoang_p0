package com.tommy_hoang_p0.Clients;

public class Client {
     private final int clientId;
     private String firstName;
     private String lastName;
     private String clientAddress;
     private String email;
     private String phoneNumber;
     private String password;
     public Client(int clientId, String firstName, String lastName, String clientAddress) {
          this.clientId = clientId;
          this.firstName = firstName;
          this.lastName = lastName;
          this.clientAddress = clientAddress;
     }
     public int getClientId() {
          return clientId;
     }
     public String getFirstName() {
          return firstName;
     }
     public String getLastName() {
          return lastName;
     }
     public String getClientAddress() {
          return clientAddress;
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
     public void setClientAddress(String clientAddress) {
          this.clientAddress = clientAddress;
     }
     public void setEmail(String email) {
          this.email = email;
     }
     public void setPhoneNumber(String phoneNumber) {
          this.phoneNumber = phoneNumber;
     }
     public void setPassword(String password) {
          this.password = password;
     }
     @Override
     public String toString() {
          return "Client{" +
                  "clientId=" + clientId +
                  ", firstName='" + firstName + '\'' +
                  ", lastName='" + lastName + '\'' +
                  ", clientAddress='" + clientAddress + '\'' +
                  ", email='" + email + '\'' +
                  ", phoneNumber='" + phoneNumber + '\'' +
                  ", password='" + password + '\'' +
                  '}';
     }
}
