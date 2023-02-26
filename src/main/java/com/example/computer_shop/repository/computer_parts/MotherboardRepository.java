package com.example.computer_shop.repository.computer_parts;

import com.example.computer_shop.model.default_components.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
}
