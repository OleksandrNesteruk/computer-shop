package com.example.computer_shop.service;

import com.example.computer_shop.model.Order;
import com.example.computer_shop.model.ShoppingCart;
import com.example.computer_shop.model.User;

import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);
    List<Order> getOrdersHistory(User user);
}
