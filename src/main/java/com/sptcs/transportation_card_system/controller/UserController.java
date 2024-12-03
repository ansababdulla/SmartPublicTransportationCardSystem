package com.sptcs.transportation_card_system.controller;

import com.sptcs.transportation_card_system.model.User;
import com.sptcs.transportation_card_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to create or update a user
    @PostMapping("/save")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Endpoint to find a user by username
    @GetMapping("/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    // Endpoint to find a user by phone number
    @GetMapping("/phone/{phoneNo}")
    public Optional<User> getUserByPhoneNo(@PathVariable String phoneNo) {
        return userService.findByPhoneNo(phoneNo);
    }

    // Endpoint to find a user by username and password (for login)
    @PostMapping("/login")
    public Optional<User> getUserByUsernameAndPassword(@RequestParam String username, @RequestParam String password) {
        return userService.findByUsernameAndPassword(username, password);
    }
}
