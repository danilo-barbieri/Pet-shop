package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {GeneroValidator.class})
public @interface Genero {
    String message() default "Sexo Inválido!!! Sexo valído: Macho ou Femea ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] allowedValues() default {"macho", "femea"};
}