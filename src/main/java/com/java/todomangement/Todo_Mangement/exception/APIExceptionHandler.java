package com.java.todomangement.Todo_Mangement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(TodoException.class)
    public ResponseEntity<ErrorResponse> todExceptionHandler(TodoException exception, WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND, webRequest.getDescription(false), LocalDate.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    //@ExceptionHandler(RuntimeException.class)
}
