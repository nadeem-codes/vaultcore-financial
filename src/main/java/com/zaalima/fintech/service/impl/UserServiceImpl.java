package com.zaalima.fintech.service.impl;

import com.zaalima.fintech.entity.User;
import com.zaalima.fintech.repository.UserRepository;
import com.zaalima.fintech.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ CREATE USER
    @Override
    public User createUser(String name,
                           String email,
                           String password,
                           String role) {

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User(name, email, hashedPassword, role);

        return userRepository.save(user);
    }

    // ✅ FIND BY EMAIL
    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // ✅ GET BY ID
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }
}