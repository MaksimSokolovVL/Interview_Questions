package com.example.sokolov.interviewquestions.repository;

import com.example.sokolov.interviewquestions.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r")
    Set<Role> findAllRoles();

    Role findByRoleName(String roleName);
}
