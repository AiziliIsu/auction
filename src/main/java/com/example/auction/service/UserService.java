package com.example.auction.service;

import com.example.auction.model.User;
import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getUserById(Long id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
