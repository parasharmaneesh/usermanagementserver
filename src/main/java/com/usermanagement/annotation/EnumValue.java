package com.usermanagement.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.usermanagement.validator.EnumValidator;

@Retention(RUNTIME)
@Target({FIELD})
@Constraint(validatedBy = EnumValidator.class)
public @interface EnumValue {
	String message() default "Invalid gender";
	Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    Class<? extends Enum> enumClass();
}
