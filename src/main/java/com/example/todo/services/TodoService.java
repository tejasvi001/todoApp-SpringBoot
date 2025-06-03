package com.example.todo.services;

import com.example.todo.dtos.TodoDTO;

import java.util.List;
import java.util.Map;

public interface TodoService {
    List<TodoDTO> getAllTodos();

    TodoDTO addTodo(TodoDTO todoDTO);

    TodoDTO getToDoByID(Long id);

    TodoDTO deleteByID(Long id);

    TodoDTO updateTodo(Long id, TodoDTO todo);

    TodoDTO updateTodo(Long id, Map<String, Object> updates);
}
