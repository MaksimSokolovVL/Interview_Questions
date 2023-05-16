package com.example.sokolov.interviewquestions.service;

import com.example.sokolov.interviewquestions.domain.entity.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();

    Role findByRoleName(String roleName);
}
