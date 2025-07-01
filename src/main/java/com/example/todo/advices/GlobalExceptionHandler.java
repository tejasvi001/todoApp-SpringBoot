package com.example.todo.advices;

import com.example.todo.exceptions.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<?> handleTodoNotFoundException(TodoNotFoundException exception){
        APIError apiError= APIError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return buildErrorResponseEntity(apiError);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        APIError apiError= APIError
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return buildErrorResponseEntity(apiError);
    }
    private ResponseEntity<APIResponse<?>> buildErrorResponseEntity(APIError apiError) {
        return  new ResponseEntity<>(new APIResponse<>(apiError),apiError.getStatus());
    }
}
