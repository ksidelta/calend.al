package com.ksidelta.calendal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component

public class FacebookConfig {
    @Value("${facebook.clientId}")
    public String clientId;

    @Value("${facebook.clientSecret}")
    public String clientSecret;

    public String getAccessToken() {
        return this.clientId + "|" + this.clientSecret;
    }
}
