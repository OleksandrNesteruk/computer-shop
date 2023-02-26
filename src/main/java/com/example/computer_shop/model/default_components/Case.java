package com.example.computer_shop.model.default_components;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cases")
@Getter
@Setter
@NoArgsConstructor
public class Case {
    public Case(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String size;
    private double price;
}
