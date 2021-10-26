package com.example.spring_bootstrap.controller;

import com.example.spring_bootstrap.model.Role;
import com.example.spring_bootstrap.model.User;
import com.example.spring_bootstrap.service.RoleService;
import com.example.spring_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/admin")
    public String listUsers(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userService.allUser());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin";
    }

    @GetMapping(value = "/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "user";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : checkBoxRoles) {
            roleSet.add(roleService.getRole(role));
        }
        user.setRoles(roleSet);
        userService.add(user);
        return "redirect:/admin";
    }

    @PatchMapping(value = "/admin/editUser")
    public String editUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : checkBoxRoles) {
            roleSet.add(roleService.getRole(roles));
        }
        user.setRoles(roleSet);
        userService.edit(user);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/admin/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.remove(id);
        return "redirect:/admin";
    }
}
