package com.tommy_hoang_p0.Util.Auth;

import javax.security.sasl.AuthenticationException;

import com.tommy_hoang_p0.Users.User;
import com.tommy_hoang_p0.Users.UserService;

public class AuthService {

     private final UserService userService;

     public AuthService(UserService userService) {
          this.userService = userService;
     }

     public User login(String email, String password) throws AuthenticationException {
          User user = userService.login(email, password);
          if (user == null)
               throw new AuthenticationException("Invalid email or password.");
          return user;
     }
}
