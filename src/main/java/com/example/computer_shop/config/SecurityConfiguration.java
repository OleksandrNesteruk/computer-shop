package com.example.computer_shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/register", "/login").permitAll()
                .requestMatchers(HttpMethod.POST, "orders/complete").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/shopping-carts/computer").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/computers", "/orders").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/shopping-carts/by-user").hasAnyAuthority("USER", "ADMIN")
                .anyRequest().authenticated().and()
                .formLogin().permitAll()
                .and()
                .httpBasic();
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}