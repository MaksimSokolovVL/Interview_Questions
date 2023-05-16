package com.example.sokolov.interviewquestions.controller;

import com.example.sokolov.interviewquestions.util.JoinedRolesUtil;
import com.example.sokolov.interviewquestions.domain.entity.User;
import com.example.sokolov.interviewquestions.service.RoleService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RoleService roleService;

    public AdminController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String adminPanel(Model model, Authentication auth){
        User userAuth = (User) auth.getPrincipal();
        model.addAttribute("roles_list_userAuth", JoinedRolesUtil.joinRoles(userAuth));
        model.addAttribute("user_auth", userAuth);
        model.addAttribute("all_roles", roleService.getAllRoles());
        return "admin";
    }
}
