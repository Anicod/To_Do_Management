package com.java.todomangement.Todo_Mangement.service.impl;

import com.java.todomangement.Todo_Mangement.dto.LoginDto;
import com.java.todomangement.Todo_Mangement.dto.RegisterDto;
import com.java.todomangement.Todo_Mangement.entity.Role;
import com.java.todomangement.Todo_Mangement.entity.User;
import com.java.todomangement.Todo_Mangement.exception.TodoException;
import com.java.todomangement.Todo_Mangement.repository.RolesRepository;
import com.java.todomangement.Todo_Mangement.repository.UserRepository;
import com.java.todomangement.Todo_Mangement.securitty.JWTTokenProvider;
import com.java.todomangement.Todo_Mangement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    private RolesRepository rolesRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JWTTokenProvider jwtTokenProvider;
    @Override
    public String authService(RegisterDto registerDto) {
        //check username already exsist throw the exception
        if(userRepository.existsByUserName(registerDto.getUserName())){
            throw new TodoException("user Already Exsit");
        }
        //check email already exsist throw exception
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new TodoException("user email already exsist");
        }
        User user = new User();
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setUserName(registerDto.getUserName());
        Set<Role> roles = new HashSet<>();
        Role role = rolesRepository.findByName("ROLE_USER");
        roles.add(role);
        user.setRoleSet(roles);
        userRepository.save(user);
        return "Register Successfully";
    }

    @Override
    public String loginAuth(LoginDto loginDto) {
       Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUserNameOrPassword(), loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.genrateToken(authentication);
        return token;
    }
}
