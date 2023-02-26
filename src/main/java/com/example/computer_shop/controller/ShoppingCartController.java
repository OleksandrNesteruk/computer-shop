package com.example.computer_shop.controller;

import com.example.computer_shop.dto.ShoppingCartResponseDto;
import com.example.computer_shop.mappers.ShoppingCartMapper;
import com.example.computer_shop.model.User;
import com.example.computer_shop.model.computer_types.Computer;
import com.example.computer_shop.service.ComputerService;
import com.example.computer_shop.service.ShoppingCartService;
import com.example.computer_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ComputerService computerService;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;


    @PutMapping("/computer")
    public void addToCart(Authentication auth, @RequestParam Long computerId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email);
        Computer computer = computerService.findById(computerId);
        shoppingCartService.addComputer(computer, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email);
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
