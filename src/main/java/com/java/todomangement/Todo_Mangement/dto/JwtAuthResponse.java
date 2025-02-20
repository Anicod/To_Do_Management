package com.java.todomangement.Todo_Mangement.dto;

public class JwtAuthResponse {
    private String bearer = "bearer";
    private String token;

    public JwtAuthResponse(String bearer, String token) {
        this.bearer = bearer;
        this.token = token;
    }
    public JwtAuthResponse(){

    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
