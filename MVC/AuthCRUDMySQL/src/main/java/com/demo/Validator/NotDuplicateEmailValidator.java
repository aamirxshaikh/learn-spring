package com.demo.Validator;

import com.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class NotDuplicateEmailValidator implements ConstraintValidator<NotDuplicateEmail, String> {
    @Autowired
    UserService userService;

    @Override
    public void initialize(NotDuplicateEmail notDuplicateEmail) {}

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return ! userService.doesEmailExist(email);
    }
}
