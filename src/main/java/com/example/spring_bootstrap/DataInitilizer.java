package com.example.spring_bootstrap;

import com.example.spring_bootstrap.model.Role;
import com.example.spring_bootstrap.model.User;
import com.example.spring_bootstrap.service.RoleService;
import com.example.spring_bootstrap.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitilizer {

    private final UserService userService;
    private final RoleService roleService;

    public DataInitilizer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void getUserTest() {
        Set<Role> roleSet = new HashSet<>();
        roleService.addRole(new Role("USER"));
        roleSet.add(roleService.getRole("USER"));
        userService.add(new User("user", "userLastname", 30, "user@email.ru", "user", roleSet));
    }

    @PostConstruct
    public void getAdminTest() {
        Set<Role> roleSet = new HashSet<>();
        roleService.addRole(new Role("ADMIN"));
        roleSet.add(roleService.getRole("ADMIN"));
        roleSet.add(roleService.getRole("USER"));
        userService.add(new User("admin", "adminLastname", 50, "admin@email.ru", "admin", roleSet));
    }
}
