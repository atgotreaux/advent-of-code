package com.gotreaux.aoc.validation;

import com.gotreaux.aoc.annotations.EventDays;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import org.springframework.lang.Nullable;

public class EventDaysValidator implements ConstraintValidator<EventDays, Integer[]> {
    @Override
    public boolean isValid(
            @Nullable Integer[] days, ConstraintValidatorContext constraintValidatorContext) {
        return days == null || Arrays.stream(days).noneMatch(i -> i < 1 || i > 25);
    }
}
