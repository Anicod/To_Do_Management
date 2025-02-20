package com.java.todomangement.Todo_Mangement.service.impl;

import com.java.todomangement.Todo_Mangement.dto.ToDoDto;
import com.java.todomangement.Todo_Mangement.entity.TodoEntity;
import com.java.todomangement.Todo_Mangement.repository.TodoRepository;
import com.java.todomangement.Todo_Mangement.service.TodoServe;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoImpl implements TodoServe {
    @Autowired
    TodoRepository todoRepository;
    ModelMapper modelMapper;
    @Override
    public ToDoDto createTodos(ToDoDto toDoDto) {
        TodoEntity todoEntity = new TodoEntity(toDoDto.getId(), toDoDto.getTitle(), toDoDto.getDescription(), toDoDto.isComplited());
        TodoEntity todoEntity1 = todoRepository.save(todoEntity);
        ToDoDto toDoDto1 = modelMapper.map(todoEntity1, ToDoDto.class);
        return toDoDto1;
    }

    @Override
    public ToDoDto gettodos(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        ToDoDto toDoDto = modelMapper.map(todoEntity, ToDoDto.class);
        return toDoDto;
    }

    @Override
    public List<ToDoDto> getAllToDo() {
        List<TodoEntity> alltodo = todoRepository.findAll();
        return alltodo.stream().map((m)->conver(m)).collect(Collectors.toList());
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
    public ToDoDto conver(TodoEntity todoEntity){
        return modelMapper.map(todoEntity, ToDoDto.class);
    }

}
