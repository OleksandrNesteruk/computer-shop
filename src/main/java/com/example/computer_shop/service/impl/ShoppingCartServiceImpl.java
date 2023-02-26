package com.example.computer_shop.service.impl;

import com.example.computer_shop.model.ShoppingCart;
import com.example.computer_shop.model.User;
import com.example.computer_shop.model.computer_types.Computer;
import com.example.computer_shop.repository.ShoppingCartRepository;
import com.example.computer_shop.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    @Override
    public void addComputer(Computer computer, User user) {
        ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByUser(user);
        shoppingCart.getComputers().add(computer);
        shoppingCart.setTotalPrice(evaluateTotalPrice(shoppingCart.getComputers()));
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartRepository.getShoppingCartByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setComputers(null);
        shoppingCartRepository.save(shoppingCart);
    }

    private double evaluateTotalPrice(List<Computer> computers) {
       return computers.stream()
               .mapToDouble(Computer::getPrice)
               .sum();
    }
}
