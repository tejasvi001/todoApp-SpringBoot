package com.example.todo.controllers;

import com.example.todo.dtos.TodoDTO;
import com.example.todo.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todo")

public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoDTO> getAllTodos(){
        return todoService.getAllTodos();
    }
    @PostMapping
    public TodoDTO addTodo(@RequestBody TodoDTO todoDTO){
        return todoService.addTodo(todoDTO);
    }

    @GetMapping("/{id}")
    public TodoDTO getToDoById(@PathVariable Long id){
        return todoService.getToDoByID(id);
    }
    @DeleteMapping("/{id}")
    public TodoDTO deleteTodoById(@PathVariable Long id){
        return todoService.deleteByID(id);
    }
    @PutMapping("/{id}")
    public TodoDTO updateToDo(@RequestBody TodoDTO todo,@PathVariable Long id){
        return todoService.updateTodo(id,todo);
    }
}
