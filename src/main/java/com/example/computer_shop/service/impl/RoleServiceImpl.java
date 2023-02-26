package com.example.computer_shop.service.impl;

import com.example.computer_shop.model.Role;
import com.example.computer_shop.repository.RoleRepository;
import com.example.computer_shop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.getRoleByName(Role.RoleName.valueOf(roleName));
    }
}
