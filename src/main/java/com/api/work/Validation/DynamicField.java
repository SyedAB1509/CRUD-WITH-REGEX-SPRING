package com.api.work.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = DynamicValidtor.class)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicField {
//error message
String message() default "Name can not accept Integer values";
Class<?> [] groups() default {};
Class<? extends Payload> [] payLoad() default {};

//String fieldName();







}
