package com.rishavkdu.springAnnotations.demo.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidAgeValidation.class)
public @interface ValidAge {
    String message() default "User is before after 2000-01-01";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
