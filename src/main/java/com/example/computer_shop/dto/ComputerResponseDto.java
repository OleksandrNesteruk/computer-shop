package com.example.computer_shop.dto;

import com.example.computer_shop.model.default_components.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class ComputerResponseDto {
    private String name;
    private CPU cpu;
    private Motherboard motherboard;
    private GPU gpu;
    private Case computerCase;
    private List<RAM> ram;
    private PowerModule powerModule;
    private double price;
}
