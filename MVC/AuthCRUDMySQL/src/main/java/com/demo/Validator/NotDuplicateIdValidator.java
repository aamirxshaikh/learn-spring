package com.demo.Validator;

import com.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class NotDuplicateIdValidator implements ConstraintValidator<NotDuplicateId, Integer> {
    @Autowired
    UserService userService;

    @Override
    public void initialize(NotDuplicateId constraintAnnotation) {}

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return ! userService.doesIdExist(id);
    }
}
