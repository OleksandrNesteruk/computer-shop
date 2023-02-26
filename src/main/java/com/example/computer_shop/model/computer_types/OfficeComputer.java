package com.example.computer_shop.model.computer_types;

import com.example.computer_shop.model.drives.FDD;
import com.example.computer_shop.model.drives.HDD;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfficeComputer extends Computer {
    @ManyToOne
    private FDD floppyDisk;
    @ManyToOne
    private HDD hardDrive;
}
