package com.tommy_hoang_p0.Members;

public class Member {
     private int memberId;
     private MemberType type;
     private String firstName;
     private String lastName;
     private String email;
     private String phoneNumber;
     private String password;
     private String street_address;
     
     public enum MemberType {
          ADMIN, EMPLOYEE, CUSTOMER
     }
     
     public Member(){}

     public Member(int memberId, MemberType type, String firstName, String lastName, String email, String phoneNumber, String password, String street_address) {
          this.memberId = memberId;
          this.type = type;
          this.firstName = firstName;
          this.lastName = lastName;
          this.email = email;
          this.phoneNumber = phoneNumber;
          this.password = password;
          this.street_address = street_address;
     }
     public int getMemberId() {
          return memberId;
     }
     public MemberType getType() {
          return type;
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
     public String getStreet_address() {
          return street_address;
     }
     public void setMemberId(int memberId) {
          this.memberId = memberId;
     }
     public void setType(String type) {
          this.type = MemberType.valueOf(type);
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
     public void setStreet_address(String street_address) {
          this.street_address = street_address;
     }
     @Override
     public String toString() {
          return "Member{" +
                  "memberId=" + memberId +
                  ", type=" + type +
                  ", firstName='" + firstName + '\'' +
                  ", lastName='" + lastName + '\'' +
                  ", email='" + email + '\'' +
                  ", phoneNumber='" + phoneNumber + '\'' +
                  ", password='" + password + '\'' +
                  ", street_address='" + street_address + '\'' +
                  '}';
     }
}
