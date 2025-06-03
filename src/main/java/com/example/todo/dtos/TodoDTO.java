package com.example.todo.dtos;

import com.example.todo.annotations.StatusValidation;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class TodoDTO {

    private Long id;
    @NotBlank
    private String title;
    @StatusValidation
    private String status;
    private String description;
    private Date dueDate;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TodoDTO() {
    }

    public TodoDTO(Long id, String title, String status, String description, Date dueDate) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
        this.dueDate = dueDate;
    }
}
