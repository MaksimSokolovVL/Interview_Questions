package com.example.sokolov.interviewquestions.service;

import com.example.sokolov.interviewquestions.domain.entity.Role;
import com.example.sokolov.interviewquestions.domain.entity.User;
import com.example.sokolov.interviewquestions.repository.RoleRepo;
import com.example.sokolov.interviewquestions.repository.UserRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public UserServiceImpl(UserRepo userRepo,
                           RoleRepo roleRepo,
                           PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("There is no user with this LOGIN: %s", username));
        }
        System.err.println("User email: " + user.getEmail() + ", password: " + user.getPassword());
        Hibernate.initialize(user.getRoles());
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    @Transactional
    public void saveAndUpdateUser(User user) {
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            Set<Role> roles = new HashSet<>();
            for (Role role : user.getRoles()) {
                Role existingRole = roleRepo.findByRoleName(role.getRoleName());
                if (existingRole != null) {
                    roles.add(existingRole);
                } else {
                    roles.add(role);
                }
            }
            user.setRoles(roles);
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserForId(Long id) {
        User user = null;
        Optional<User> byId = userRepo.findById(id);
        if (byId.isPresent()) {
            user = byId.get();
        }
        return user;
    }

    @Override
    public boolean checkedUserByEmail(String email) {
        return userRepo.findByEmail(email) != null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
