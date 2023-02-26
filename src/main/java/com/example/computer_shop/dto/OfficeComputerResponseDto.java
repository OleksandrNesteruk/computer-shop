package com.example.computer_shop.dto;

import com.example.computer_shop.model.drives.FDD;
import com.example.computer_shop.model.drives.HDD;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfficeComputerResponseDto extends ComputerResponseDto{
    private FDD floppyDisk;
    private HDD hardDrive;
}
