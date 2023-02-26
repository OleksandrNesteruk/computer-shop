package com.example.computer_shop.repository;

import com.example.computer_shop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("FROM Role r WHERE r.name = ?1")
    Role getRoleByName(Role.RoleName name);
}
