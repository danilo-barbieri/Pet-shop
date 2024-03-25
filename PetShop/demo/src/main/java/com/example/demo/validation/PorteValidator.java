package com.example.demo.validation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PorteValidator implements ConstraintValidator<Porte, String> {

    private String[] allowedValues;

    @Override
    public void initialize(Porte constraintAnnotation){

        this.allowedValues = constraintAnnotation.allowedValues();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return Arrays.asList(allowedValues).contains(value.toLowerCase());
    }
}