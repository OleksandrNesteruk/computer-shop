package com.example.computer_shop.service.impl;

import com.example.computer_shop.model.Order;
import com.example.computer_shop.model.ShoppingCart;
import com.example.computer_shop.model.User;
import com.example.computer_shop.repository.OrderRepository;
import com.example.computer_shop.service.OrderService;
import com.example.computer_shop.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setComputers(new ArrayList<>(shoppingCart.getComputers()));
        order.setUser(shoppingCart.getUser());
        order.setTotalPrice(shoppingCart.getTotalPrice());
        orderRepository.save(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderRepository.getOrdersHistory(user);
    }
}
