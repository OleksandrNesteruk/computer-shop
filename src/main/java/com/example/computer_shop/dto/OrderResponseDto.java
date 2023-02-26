package com.example.computer_shop.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private List<ComputerDto> computers;
    private String email;
    private double totalPrice;
    private LocalDateTime orderTime;
}
