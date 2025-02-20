package com.java.todomangement.Todo_Mangement.controller;

import com.java.todomangement.Todo_Mangement.dto.ToDoDto;
import com.java.todomangement.Todo_Mangement.service.TodoServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    TodoServe todoServe;
    @PostMapping("/create")
    public ResponseEntity<ToDoDto> createTodo(@RequestBody ToDoDto toDoDto){
        ToDoDto toDoDto1 = todoServe.createTodos(toDoDto);
        return new ResponseEntity<>(toDoDto1, HttpStatus.CREATED);
    }
    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDoDto> gettodo(@PathVariable Long id){
        ToDoDto toDoDto1 = todoServe.gettodos(id);
        return new ResponseEntity<>(toDoDto1, HttpStatus.OK);
    }
    @GetMapping("/alltodo")
    public ResponseEntity<List<ToDoDto>> getalltodo(){
        List<ToDoDto> alltodo = todoServe.getAllToDo();
        return new ResponseEntity<>(alltodo, HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public String deletetodo(@PathVariable Long id){
        todoServe.deleteTodo(id);
        return "delete successfully";
    }

}
