package com.java.todomangement.Todo_Mangement.controller;

import com.java.todomangement.Todo_Mangement.dto.JwtAuthResponse;
import com.java.todomangement.Todo_Mangement.dto.LoginDto;
import com.java.todomangement.Todo_Mangement.dto.RegisterDto;
import com.java.todomangement.Todo_Mangement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class RegisterController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<String> registeruser(@RequestBody RegisterDto registerDto){
        String message = authService.authService(registerDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> loginUser(@RequestBody LoginDto loginDto){
        String token = authService.loginAuth(loginDto);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken(token);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.CREATED);
    }

}
