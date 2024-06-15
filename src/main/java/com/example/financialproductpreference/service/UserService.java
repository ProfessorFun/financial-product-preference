package com.example.financialproductpreference.service;

import com.example.financialproductpreference.entity.User;
import com.example.financialproductpreference.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(String userId, User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setUserName(userDetails.getUserName());
        user.setEmail(userDetails.getEmail());
        user.setAccount(userDetails.getAccount());
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }
}

// Similar services for Product and LikeList
