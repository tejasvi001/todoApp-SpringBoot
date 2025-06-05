package com.example.todo.exceptions;

public class TodoNotFoundException extends Exception{
    public TodoNotFoundException(String s){
        super(s);
    }
}
