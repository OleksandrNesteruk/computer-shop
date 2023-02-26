package com.example.computer_shop.dto;

import com.example.computer_shop.model.cooling_systems.CPUAirCooling;
import com.example.computer_shop.model.drives.HDD;
import com.example.computer_shop.model.drives.SSD;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeComputerResponseDto extends ComputerResponseDto{
    private CPUAirCooling cooling;
    private SSD drive;
    private HDD hardDrive;
}
