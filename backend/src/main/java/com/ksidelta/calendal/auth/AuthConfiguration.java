package com.ksidelta.calendal.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {
    @Bean
    public AuthService authService() {
        return () -> "google|KAŁAMAJKA";
    }
}
