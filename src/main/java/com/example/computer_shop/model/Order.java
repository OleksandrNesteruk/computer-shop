package com.example.computer_shop.model;

import java.time.LocalDateTime;
import java.util.List;
import com.example.computer_shop.model.computer_types.Computer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinTable(name = "orders_computers",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "in_order_computer_id"))
    private List<Computer> computers;
    @Column(name = "order_time")
    private LocalDateTime orderTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private double totalPrice;
}
