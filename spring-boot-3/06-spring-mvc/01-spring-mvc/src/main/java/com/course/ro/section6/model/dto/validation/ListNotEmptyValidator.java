package com.course.ro.section6.model.dto.validation;

import com.course.ro.section6.model.dto.validation.annotation.ListNotEmpty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ListNotEmptyValidator implements ConstraintValidator<ListNotEmpty, List> {

    private String kunwariVariableTo;

    @Override
    public void initialize(ListNotEmpty constraintAnnotation) {
        kunwariVariableTo = constraintAnnotation.message(); //in case u need additional attributes to be set in the future
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        return list != null && !list.isEmpty();
    }
}
