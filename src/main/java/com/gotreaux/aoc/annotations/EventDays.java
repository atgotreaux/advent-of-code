package com.gotreaux.aoc.annotations;

import com.gotreaux.aoc.validation.EventDaysValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EventDaysValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface EventDays {
    String message() default "Event days must be in the range of 1-25";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
