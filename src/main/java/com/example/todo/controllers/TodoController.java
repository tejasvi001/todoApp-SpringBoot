package com.example.todo.controllers;

import com.example.todo.dtos.TodoDTO;
import com.example.todo.services.TodoService;
import com.example.todo.services.TodoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/todo")

public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos(){
        return ResponseEntity.status(200).body(todoService.getAllTodos());
    }
    @PostMapping
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO){
        return ResponseEntity.status(201).body(todoService.addTodo(todoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getToDoById(@PathVariable Long id){
        return ResponseEntity.status(200).body(todoService.getToDoByID(id));
    }

    @DeleteMapping("/{id}")
    public TodoDTO deleteTodoById(@PathVariable Long id){
        return todoService.deleteByID(id);
    }

    @PutMapping("/{id}")
    public TodoDTO updateToDo(@RequestBody TodoDTO todo,@PathVariable Long id){
        return todoService.updateTodo(id,todo);
    }

    @PatchMapping("/{id}")
    public TodoDTO updateToDo(@PathVariable Long id,@RequestBody Map<String,Object> updates){
        return todoService.updateTodo(id,updates);
    }




}
