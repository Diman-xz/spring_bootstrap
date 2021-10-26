package com.example.spring_bootstrap.service;

import com.example.spring_bootstrap.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRole(String role);

    void addRole(Role role);
}
