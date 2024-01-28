package com.gotreaux.aoc.annotations;

import com.gotreaux.aoc.validation.EventYearsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EventYearsValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface EventYears {
    String message() default "Event years must be in the range of 2015-2023";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
