package com.zaalima.fintech.service.impl;

import com.zaalima.fintech.dto.AuthRequest;
import com.zaalima.fintech.dto.JwtResponse;
import com.zaalima.fintech.entity.User;
import com.zaalima.fintech.exception.UnauthorizedException;
import com.zaalima.fintech.security.JwtTokenProvider;
import com.zaalima.fintech.service.AuthService;
import com.zaalima.fintech.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserService userService,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public JwtResponse login(AuthRequest request) {

        User user = userService
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new UnauthorizedException("Invalid credentials"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new UnauthorizedException("Invalid credentials");
        }

        String accessToken =
                jwtTokenProvider.generateAccessToken(user);

        String refreshToken =
                jwtTokenProvider.generateRefreshToken(user);

        return new JwtResponse(accessToken, refreshToken);
    }

    @Override
    public JwtResponse register(AuthRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public JwtResponse authenticate(AuthRequest request) {
        return login(request);
    }

    @Override
    public void logout(String accessToken) {
        // Optional — can stay empty
    }
}