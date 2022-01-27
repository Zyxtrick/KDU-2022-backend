package com.rishavkdu.springAnnotations.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class ValidAgeValidation implements ConstraintValidator<ValidAge, String> {

    @Override
    public void initialize(ValidAge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext constraintValidatorContext) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.US)
                                                            .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        boolean isAfter = LocalDate.parse(dateStr).isAfter(LocalDate.parse("2000-01-01"));
        return isAfter;
//        return false;
    }
}
