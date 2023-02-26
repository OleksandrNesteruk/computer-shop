package com.example.computer_shop.service;

import com.example.computer_shop.model.User;

public interface UserService {
    User add(User user);

    User findByEmail(String email);
}
