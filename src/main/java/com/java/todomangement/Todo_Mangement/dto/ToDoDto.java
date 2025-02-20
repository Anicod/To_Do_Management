package com.java.todomangement.Todo_Mangement.dto;

public class ToDoDto {
    private Long id;
    private String title;
    private String description;
    private boolean complited;

    public ToDoDto(Long id, String title, String description, boolean complited) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.complited = complited;
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
