package com.example.sokolov.interviewquestions.service;

import com.example.sokolov.interviewquestions.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDetails loadUserByUsername(String email);

    User findByUsername(String email);

    void saveAndUpdateUser(User user);

    List<User> getAllUsers();

    User getUserForId(Long id);

    boolean checkedUserByEmail(String email);

    void deleteUser(Long id);
}
