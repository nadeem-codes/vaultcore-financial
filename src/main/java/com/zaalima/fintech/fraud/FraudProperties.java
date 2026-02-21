package com.zaalima.fintech.fraud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@ConfigurationProperties(prefix = "fraud")
public class FraudProperties {

    /**
     * If transaction amount exceeds this threshold,
     * 2FA verification is required.
     */
    private BigDecimal threshold;

    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }
}
