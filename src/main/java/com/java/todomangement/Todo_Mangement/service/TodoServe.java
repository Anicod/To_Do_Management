package com.java.todomangement.Todo_Mangement.service;

import com.java.todomangement.Todo_Mangement.dto.ToDoDto;

import java.util.List;

public interface TodoServe {
    public ToDoDto createTodos(ToDoDto toDoDto);
    public ToDoDto gettodos(Long id);
    public List<ToDoDto> getAllToDo();
    public void deleteTodo(Long id);
}
