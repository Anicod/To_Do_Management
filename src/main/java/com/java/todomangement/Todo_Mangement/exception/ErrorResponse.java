package com.java.todomangement.Todo_Mangement.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public record ErrorResponse(String errordesc, HttpStatus errcode, String path, LocalDate localDate) {
}
