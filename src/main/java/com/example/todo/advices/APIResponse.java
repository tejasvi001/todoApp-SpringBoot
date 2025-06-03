package com.example.todo.advices;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class APIResponse<T>{
    private T data;
    private APIError apiError;
    private LocalDateTime timeStamp;
    APIResponse(){
        this.timeStamp=LocalDateTime.now();
    }
    APIResponse(T data){
        this();
        this.data=data;
    }
    APIResponse(APIError apiError){
        this();
        this.apiError=apiError;
    }
}
