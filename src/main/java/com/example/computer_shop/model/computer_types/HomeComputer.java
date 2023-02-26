package com.example.computer_shop.model.computer_types;

import com.example.computer_shop.model.cooling_systems.CPUAirCooling;
import com.example.computer_shop.model.drives.HDD;
import com.example.computer_shop.model.drives.SSD;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeComputer extends Computer {
    @ManyToOne
    private CPUAirCooling cooling;
    @ManyToOne
    private SSD drive;
    @ManyToOne
    private HDD hardDrive;
}
