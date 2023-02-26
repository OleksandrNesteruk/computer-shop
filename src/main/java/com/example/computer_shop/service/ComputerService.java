package com.example.computer_shop.service;

import com.example.computer_shop.model.computer_types.Computer;

import java.util.List;

public interface ComputerService {
    void add(Computer computer);
    Computer findById(Long id);

    List<Computer> findAll();
}
