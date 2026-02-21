package com.zaalima.fintech.service;

import com.zaalima.fintech.entity.User;

import java.util.Optional;

public interface UserService {

    // Create user
    User createUser(String name, String email, String password, String role);

    // Find by email
    Optional<User> findByEmail(String email);

    // Get by ID
    User getUserById(Long id);
}