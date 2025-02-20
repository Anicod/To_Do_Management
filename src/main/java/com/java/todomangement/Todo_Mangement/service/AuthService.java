package com.java.todomangement.Todo_Mangement.service;

import com.java.todomangement.Todo_Mangement.dto.LoginDto;
import com.java.todomangement.Todo_Mangement.dto.RegisterDto;

public interface AuthService {
    public String authService(RegisterDto registerDto);
    public String loginAuth(LoginDto loginDto);
}
