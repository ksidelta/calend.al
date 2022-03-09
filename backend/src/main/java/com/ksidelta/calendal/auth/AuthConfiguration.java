package com.ksidelta.calendal.auth;

import org.springframework.context.annotation.Bean;

public class AuthConfiguration {
    @Bean
    public AuthService authService(){
        return () -> "google|KAŁAMAJKA";
    }
}
