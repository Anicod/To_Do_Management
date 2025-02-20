package com.java.todomangement.Todo_Mangement.exception;

import org.springframework.http.HttpStatus;

public class TodoException extends RuntimeException{
    private HttpStatus status;
    private String message;
    public TodoException(String message){
        super(message);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
