package com.example.demo.validation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class AnimalTypeValidator implements ConstraintValidator<AnimalType, String> {

    private static final Set<String> ALLOWED_VALUES = new HashSet<>(Arrays.asList("cachorro", "coelho", "gato"));

    @Override
    public void initialize(AnimalType constraintAnnotation) {
        //inicialização do metodo de validação
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && ALLOWED_VALUES.contains(value.toLowerCase());
    }
}