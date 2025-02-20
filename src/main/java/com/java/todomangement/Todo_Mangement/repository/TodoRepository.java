package com.java.todomangement.Todo_Mangement.repository;

import com.java.todomangement.Todo_Mangement.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
