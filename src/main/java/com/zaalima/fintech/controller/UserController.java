package com.zaalima.fintech.controller;

import com.zaalima.fintech.dto.UserRequest;
import com.zaalima.fintech.entity.User;
import com.zaalima.fintech.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ CREATE USER
    @PostMapping
    public ResponseEntity<Object> createUser(
            @Valid @RequestBody UserRequest request) {

        User user = userService.createUser(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                "ROLE_USER"
        );

        return ResponseEntity.ok(user);
    }
}