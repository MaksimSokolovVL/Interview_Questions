package com.example.sokolov.interviewquestions.controller;


import com.example.sokolov.interviewquestions.domain.UserRole;
import com.example.sokolov.interviewquestions.domain.entity.Role;
import com.example.sokolov.interviewquestions.domain.entity.User;
import com.example.sokolov.interviewquestions.repository.RoleRepo;
import com.example.sokolov.interviewquestions.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Set;


@Controller
public class RegistrationController {

    private final UserService userService;
    private final RoleRepo roleRepo;
    private final PasswordEncoder encoder;

    public RegistrationController(UserService userService, RoleRepo roleRepo, PasswordEncoder encoder) {
        this.userService = userService;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {

        User byUsername = userService.findByUsername(user.getUsername());
        Set<Role> allRoles = roleRepo.findAllRoles();

        if (byUsername != null) {
            model.addAttribute("user_message", "User exists!");
            return "registration";
        }

        user.setActive(true);

        if (allRoles.size() == 0) {
            user.setRoles(Collections.singleton(createdUserRole()));
        } else {
            Role byRoleName = roleRepo.findByRoleName(UserRole.USER.getName());
            user.setRoles(Collections.singleton(byRoleName != null ? byRoleName : createdUserRole()));
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userService.saveAndUpdateUser(user);
        return "redirect:/login";
    }

    private Role createdUserRole() {
        return new Role(UserRole.USER.getName());
    }
}
