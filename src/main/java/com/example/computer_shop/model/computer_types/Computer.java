package com.example.computer_shop.model.computer_types;

import com.example.computer_shop.model.default_components.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "computers")
public abstract class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private CPU cpu;
    @ManyToOne
    private GPU gpu;
    @ManyToOne
    private Motherboard motherboard;
    @ManyToMany
    @JoinTable(name = "computers_ram",
            joinColumns = @JoinColumn(name = "computer_id"),
            inverseJoinColumns = @JoinColumn(name = "ram_id"))
    @Column(name = "ram")
    private List<RAM> ram;
    @ManyToOne
    private PowerModule powerModule;
    @ManyToOne
    private Case computerCase;
    private double price;
}
