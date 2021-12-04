package com.demo.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotDuplicateEmailValidator.class)
@Documented
public @interface NotDuplicateEmail {
    String message() default  "Email Already Exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
