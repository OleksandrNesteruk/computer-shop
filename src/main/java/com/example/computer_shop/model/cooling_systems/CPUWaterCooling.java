package com.example.computer_shop.model.cooling_systems;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "water_cooling")
@Getter
@Setter
@NoArgsConstructor
public class CPUWaterCooling {
    public CPUWaterCooling(Byte noise, String liquidType, double price) {
        this.noise = noise;
        this.liquidType = liquidType;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte noise;
    private String liquidType;
    private double price;

}
