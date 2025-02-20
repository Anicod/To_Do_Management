package com.java.todomangement.Todo_Mangement.dto;

public class LoginDto {
    private String userNameOrPassword;
    private String password;

    public LoginDto(String userNameOrPassword, String password) {
        this.userNameOrPassword = userNameOrPassword;
        this.password = password;
    }

    public String getUserNameOrPassword() {
        return userNameOrPassword;
    }

    public void setUserNameOrPassword(String userNameOrPassword) {
        this.userNameOrPassword = userNameOrPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
