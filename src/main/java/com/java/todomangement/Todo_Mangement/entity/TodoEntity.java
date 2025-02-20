package com.java.todomangement.Todo_Mangement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Todos")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    private boolean complited;

    public TodoEntity(Long id, String title, String description, boolean complited) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.complited = complited;
    }
    public TodoEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplited() {
        return complited;
    }

    public void setComplited(boolean complited) {
        this.complited = complited;
    }
}
