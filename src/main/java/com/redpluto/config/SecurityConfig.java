package com.redpluto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
	return http.csrf().disable().authorizeHttpRequests(authz -> {
	    authz.requestMatchers("/api/auth/login/**").permitAll().requestMatchers("/api/students/**").authenticated().anyRequest()
		    .authenticated();
	}).httpBasic(withDefaults()).build();
    }
}