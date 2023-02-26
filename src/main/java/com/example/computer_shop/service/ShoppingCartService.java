package com.example.computer_shop.service;

import com.example.computer_shop.model.ShoppingCart;
import com.example.computer_shop.model.User;
import com.example.computer_shop.model.computer_types.Computer;

public interface ShoppingCartService {
    void addComputer(Computer computer, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
