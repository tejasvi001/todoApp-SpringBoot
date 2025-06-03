package com.example.todo.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class StatusValidator implements ConstraintValidator<StatusValidation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null)
            return false;
        List<String> status= List.of("completed","pending");
        return status.contains(s);
    }
}
