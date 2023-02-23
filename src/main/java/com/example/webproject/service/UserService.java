package com.example.webproject.service;

import com.example.webproject.database.RoleRepository;
import com.example.webproject.database.UserRepository;
import com.example.webproject.role.Role;
import com.example.webproject.user.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public void saveUser(Users user) {
        //Role role = roleRepository.findByName(user.getUsername());
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null){
            role = checkRoleExist();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
    public Users findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<Users> findAllUsers(){
        return userRepository.findAll();
    }


    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
