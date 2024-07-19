package com.tommy_hoang_p0.Users;

import java.util.List;

import com.tommy_hoang_p0.Util.Exceptions.InvalidInputException;
import com.tommy_hoang_p0.Util.Interfaces.Serviceable;

public class UserService implements Serviceable<User> {
     private final UserRepo userRepository;

     public UserService(UserRepo userRepository) {
          this.userRepository = userRepository;
     }

     @Override
     public List<User> findAll() {
          return userRepository.findAll();
     }

     @Override
     public User findById(int userId) {
          return userRepository.findById(userId);
     }

     @Override
     public User create(User newUser) throws InvalidInputException {
          return userRepository.create(newUser);
     }

     public User login(String email, String pwd) {
          return userRepository.login(email, pwd);
     }

     public boolean update(User updatedUser) throws InvalidInputException {
          return userRepository.update(updatedUser);
     }
     public boolean delete(int id) throws InvalidInputException {
          return userRepository.delete(id);
     }
}
