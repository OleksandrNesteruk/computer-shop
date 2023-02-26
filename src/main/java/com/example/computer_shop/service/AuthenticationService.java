package com.example.computer_shop.service;

import com.example.computer_shop.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
