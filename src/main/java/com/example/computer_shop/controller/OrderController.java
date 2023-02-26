package com.example.computer_shop.controller;

import com.example.computer_shop.dto.OrderResponseDto;
import com.example.computer_shop.mappers.OrderMapper;
import com.example.computer_shop.model.ShoppingCart;
import com.example.computer_shop.model.User;
import com.example.computer_shop.service.OrderService;
import com.example.computer_shop.service.ShoppingCartService;
import com.example.computer_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final UserService userService;

    private final OrderMapper orderMapper;

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email);
        ShoppingCart cart = shoppingCartService.getByUser(user);
        return orderMapper.mapToDto(orderService.completeOrder(cart));
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email);
        return orderService.getOrdersHistory(user)
                .stream()
                .map(orderMapper::mapToDto)
                .toList();
    }
}
