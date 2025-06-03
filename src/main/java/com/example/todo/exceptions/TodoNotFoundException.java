package com.example.todo.exceptions;

public class TodoNotFoundException extends Exception{
    TodoNotFoundException(String s){
        super(s);
    }
}
