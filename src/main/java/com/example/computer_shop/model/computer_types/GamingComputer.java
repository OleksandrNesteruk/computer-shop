package com.example.computer_shop.model.computer_types;

import com.example.computer_shop.model.cooling_systems.CPUWaterCooling;
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
public class GamingComputer extends Computer {
    @ManyToOne
    private CPUWaterCooling cooling;
    @ManyToOne
    private SSD drive;
}
