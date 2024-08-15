package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.dto.UserDTO;
import com.example.RestaurantBackend.entity.Users;  // Ensure this matches your entity class name
import com.example.RestaurantBackend.repository.UsersRepository;
import com.example.RestaurantBackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository userRepository;  // Corrected the variable name

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        try {
            if (!isEmailUnique(userDTO.getEmail())) {
                throw new RuntimeException("Email already in use");
            }
            Users user = modelMapper.map(userDTO, Users.class);  // Corrected the class name
            user = userRepository.save(user);  // Corrected the repository name
            return modelMapper.map(user, UserDTO.class);
        } catch (Exception e) {
            // Log and handle the exception
            throw new RuntimeException("User creation failed", e);
        }
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(userDTO, user);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean isEmailUnique(String email) {
        return !userRepository.existsByEmail(email);
    }
}
