package com.tommy_hoang_p0.Users;

public class User {
    private int userId;
    private UserType type;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    public enum UserType {
        ADMIN, EMPLOYEE, CUSTOMER
    }

    public User() {}
    public User(int userId, UserType type) {
        this.userId = userId;
        this.type = type;
    }
    public User(int userId, UserType type, String firstName, String lastName, String email, String phone, String password) {
        this.userId = userId;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getUserId() { return userId; }
    public UserType getType() { return type; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }

    public void setUserId(int userId) { this.userId = userId; }
    public void setType(String type) { this.type = UserType.valueOf(type); }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPassword(String password) { this.password = password; }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", type=" + type +
                ", name=" + firstName + " " + lastName +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
