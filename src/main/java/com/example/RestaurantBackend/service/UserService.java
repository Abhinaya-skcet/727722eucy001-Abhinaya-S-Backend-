package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long userId, UserDTO userDTO);
    void deleteUser(Long userId);
    boolean isEmailUnique(String email);  // Add this method
}
