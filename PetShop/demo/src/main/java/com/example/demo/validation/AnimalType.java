package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AnimalTypeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AnimalType {
    String message() default "Espécie Inválida. Espécies Válidas: Cachorro, Gato ou Coelho";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}