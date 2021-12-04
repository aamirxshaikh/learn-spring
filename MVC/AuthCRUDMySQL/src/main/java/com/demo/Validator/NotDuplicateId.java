package com.demo.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotDuplicateIdValidator.class)
@Documented
public @interface NotDuplicateId {
    String message() default  "Id Already Exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
