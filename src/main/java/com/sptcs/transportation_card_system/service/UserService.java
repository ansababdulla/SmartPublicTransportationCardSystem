package com.sptcs.transportation_card_system.service;

import com.sptcs.transportation_card_system.model.User;
import com.sptcs.transportation_card_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to save a user (for registration or updating user details)
    public User saveUser(User user) {
        return userRepository.save(user);  // This method will persist the user to the database
    }

    // Method to find a user by username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Method to find a user by phone number
    public Optional<User> findByPhoneNo(String phoneNo) {
        return userRepository.findByPhoneNo(phoneNo);
    }

    // Method to find a user by username and password (for login)
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

}
