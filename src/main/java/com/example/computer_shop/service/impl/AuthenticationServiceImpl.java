package com.example.computer_shop.service.impl;

import com.example.computer_shop.model.Role;
import com.example.computer_shop.model.User;
import com.example.computer_shop.service.AuthenticationService;
import com.example.computer_shop.service.RoleService;
import com.example.computer_shop.service.ShoppingCartService;
import com.example.computer_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final RoleService roleService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getByName(Role.RoleName.USER.name())));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
