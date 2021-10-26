package com.example.spring_bootstrap.service;

import com.example.spring_bootstrap.model.Role;
import com.example.spring_bootstrap.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(String role) {
        return roleRepository.getRoleByName(role);
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
