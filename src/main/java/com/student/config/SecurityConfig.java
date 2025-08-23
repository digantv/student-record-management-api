package com.student.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf()
        .disable()
        .authorizeHttpRequests(
            authz -> {
              authz
                  .requestMatchers("/api/auth/login/**")
                  .permitAll()
                  .requestMatchers("/api/students/**")
                  .authenticated()
                  .anyRequest()
                  .authenticated();
            })
        .httpBasic(withDefaults())
        .build();
  }
}
