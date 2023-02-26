package com.example.computer_shop.model.cooling_systems;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "air_cooling")
@Getter
@Setter
@NoArgsConstructor
public class CPUAirCooling {
    public CPUAirCooling(Byte noise, Integer height, double price) {
        this.noise = noise;
        this.height = height;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte noise;
    private Integer height;
    private double price;
}
