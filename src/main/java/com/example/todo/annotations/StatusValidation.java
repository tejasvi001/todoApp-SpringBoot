package com.example.todo.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(
        validatedBy = {StatusValidator.class}
)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StatusValidation {
    String message() default "The status can be completed or pending";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
