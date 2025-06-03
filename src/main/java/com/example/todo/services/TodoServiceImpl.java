package com.example.todo.services;

import com.example.todo.dtos.TodoDTO;
import com.example.todo.entities.ToDoEntity;
import com.example.todo.repositories.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    public TodoServiceImpl(TodoRepository todoRepository, ModelMapper modelMapper) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
    }

    public List<TodoDTO> getAllTodos() {
        List<ToDoEntity> todos=todoRepository.findAll();
        if (todos == null) {
            return Collections.emptyList();
        }
        return todos.stream()
                .map(
                        toDoEntity -> modelMapper.map(
                                toDoEntity,TodoDTO.class
                        )
                )
                .collect(
                        Collectors.toList()
                );
    }

    public TodoDTO addTodo(TodoDTO todoDTO) {
        ToDoEntity todoToAdd=modelMapper.map(todoDTO, ToDoEntity.class);
        ToDoEntity savedTodo=todoRepository.save(todoToAdd);
        return modelMapper.map(savedTodo,TodoDTO.class);
    }

    public TodoDTO getToDoByID(Long id) {
        ToDoEntity todo=todoRepository.findById(id).orElse(null);
        return modelMapper.map(todo,TodoDTO.class);
    }

    public TodoDTO deleteByID(Long id) {
        TodoDTO todo=getToDoByID(id);
        todoRepository.deleteById(id);
        return todo;
    }

    public TodoDTO updateTodo(Long id, TodoDTO todo) {
        ToDoEntity toDoEntity=modelMapper.map(todo,ToDoEntity.class);
        toDoEntity.setId(id);
        ToDoEntity savedToDo= todoRepository.save(toDoEntity);
        return modelMapper.map(savedToDo, TodoDTO.class);
    }

    public TodoDTO updateTodo(Long id, Map<String, Object> updates) {
        boolean exists= todoRepository.existsById(id);
        if(exists==false){
            return null;
        }
        ToDoEntity todo=todoRepository.findById(id).orElse(null);
        updates.forEach(
                (key,value)->{
                    Field f= ReflectionUtils.findField(
                            ToDoEntity.class,key
                    );
                    f.setAccessible(true);
                    ReflectionUtils.setField(f,todo,value);
                }
        );
        ToDoEntity savedToDo= todoRepository.save(todo);
        return modelMapper.map(savedToDo, TodoDTO.class);
    }
}
