package com.example.todo.controllers;

import com.example.todo.dtos.TodoDTO;
import com.example.todo.exceptions.TodoNotFoundException;
import com.example.todo.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


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
    public ResponseEntity<Optional<TodoDTO>> getToDoById(@PathVariable Long id) {
        Optional<TodoDTO> todo= Optional.ofNullable(todoService.getToDoByID(id));
        try {
            return todo
                    .map(todoDTO -> ResponseEntity.ok(todo))
                    .orElseThrow(()->new TodoNotFoundException("Todo Not Found"));
        } catch (TodoNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoDTO> deleteTodoById(@PathVariable Long id){

        return ResponseEntity.status(200).body(todoService.deleteByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateToDo(@RequestBody TodoDTO todo,@PathVariable Long id){
        return ResponseEntity.ok(todoService.updateTodo(id,todo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoDTO> updateToDo(@PathVariable Long id,@RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(todoService.updateTodo(id,updates));
    }




}
