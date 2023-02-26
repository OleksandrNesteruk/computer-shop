package com.example.computer_shop.repository;

import com.example.computer_shop.model.ShoppingCart;
import com.example.computer_shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart getShoppingCartByUser(User user);
}
