package com.zaalima.fintech.security;

import com.zaalima.fintech.entity.User;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateAccessToken(User user) {
        return "ACCESS_TOKEN_USER_" + user.getId();
    }

    public String generateRefreshToken(User user) {
        return "REFRESH_TOKEN_USER_" + user.getId();
    }

    public String getUsername(String token) {
        return "demo@user.com";
    }

    public boolean validateToken(String token) {
        return true;
    }
}