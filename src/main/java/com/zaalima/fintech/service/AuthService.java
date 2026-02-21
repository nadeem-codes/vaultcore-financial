package com.zaalima.fintech.service;

import com.zaalima.fintech.dto.AuthRequest;
import com.zaalima.fintech.dto.JwtResponse;

public interface AuthService {

    JwtResponse register(AuthRequest request);

    JwtResponse login(AuthRequest request);

    JwtResponse authenticate(AuthRequest request);

    void logout(String accessToken);
}