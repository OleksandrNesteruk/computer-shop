package com.example.computer_shop.repository.computer_parts;

import com.example.computer_shop.model.computer_types.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
