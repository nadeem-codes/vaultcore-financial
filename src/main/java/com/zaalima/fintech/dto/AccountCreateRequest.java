package com.zaalima.fintech.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AccountCreateRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Account status is required")
    @Pattern(
        regexp = "ACTIVE|FROZEN",
        message = "Status must be ACTIVE or FROZEN"
    )
    private String status;

    // ===== Getters & Setters =====

    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
