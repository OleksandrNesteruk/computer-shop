package com.example.computer_shop.repository.computer_parts;

import com.example.computer_shop.model.drives.HDD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HDDRepository extends JpaRepository<HDD, Long> {
}
