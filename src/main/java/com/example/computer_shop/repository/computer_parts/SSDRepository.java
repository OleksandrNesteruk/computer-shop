package com.example.computer_shop.repository.computer_parts;

import com.example.computer_shop.model.drives.SSD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSDRepository extends JpaRepository<SSD, Long> {
}
