package com.example.candorbackend.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(c->c.disable())
                .formLogin(f->f.disable())
                .httpBasic(f->f.disable())
                .logout(f->f.disable())
                .sessionManagement(f->f.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(a->a.requestMatchers("/error","/actuator/health", "/openapi.yaml",
                        "/api/v1/ping", "/api/v1/auth/**").permitAll()
                        .anyRequest().authenticated());


        return http.build();
    }
}
