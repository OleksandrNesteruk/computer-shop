package com.example.computer_shop.model;

import com.example.computer_shop.model.computer_types.Computer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "shopping_carts")
@Getter
@Setter
public class ShoppingCart {
    @Id
    private Long id;
    @OneToMany
    @JoinTable(name = "shopping_carts_computers",
            joinColumns = @JoinColumn(name = "shopping_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "in_cart_computer_id"))
    private List<Computer> computers;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;
    private double totalPrice;
}
