package com.example.todoList.domain;
import javax.persistence.*;

@Entity
@Table(name = "todoList")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Status status;


    public TodoList(String description,Status status) {
        this.description = description;
        this.status = status;
    }

    public TodoList() {
    }
    public TodoList(String description) {
        this.description = description;
    }

    public TodoList(Integer id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

