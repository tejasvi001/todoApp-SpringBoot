package com.example.todo.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@Builder
public class APIError {
    private String message;
    private HttpStatus status;
}
