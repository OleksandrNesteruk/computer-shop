package com.example.computer_shop.service;

import com.example.computer_shop.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
