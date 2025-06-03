package com.course.ro.section6.model.dto.validation.annotation;

import com.course.ro.section6.model.dto.validation.ListNotEmptyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ListNotEmptyValidator.class)
//@Target({ElementType.METHOD, ElementType.FIELD})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListNotEmpty {

    String message() default "List cannot be empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
