package com.example.computer_shop.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ShoppingCartResponseDto {
    private String email;
    private List<ComputerDto> computers;
    private double totalPrice;
}
