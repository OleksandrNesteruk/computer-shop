package com.example.computer_shop.repository.computer_parts;

import com.example.computer_shop.model.cooling_systems.CPUWaterCooling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPUWaterCoolingRepository extends JpaRepository<CPUWaterCooling, Long> {
}
