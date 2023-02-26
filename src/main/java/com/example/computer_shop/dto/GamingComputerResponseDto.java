package com.example.computer_shop.dto;

import com.example.computer_shop.model.cooling_systems.CPUWaterCooling;
import com.example.computer_shop.model.drives.SSD;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GamingComputerResponseDto extends ComputerResponseDto {
    private CPUWaterCooling cooling;
    private SSD drive;
}
