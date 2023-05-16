package com.example.sokolov.interviewquestions.service;

import com.example.sokolov.interviewquestions.domain.entity.Role;
import com.example.sokolov.interviewquestions.repository.RoleRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Role> getAllRoles() {
        return roleRepo.findAllRoles();
    }

    @Override
    @Transactional(readOnly = true)
    public Role findByRoleName(String roleName) {
        return roleRepo.findByRoleName(roleName);
    }
}
