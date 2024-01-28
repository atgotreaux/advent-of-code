package com.gotreaux.aoc.validation;

import com.gotreaux.aoc.annotations.EventYears;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import org.springframework.lang.Nullable;

public class EventYearsValidator implements ConstraintValidator<EventYears, Integer[]> {
    @Override
    public boolean isValid(
            @Nullable Integer[] years, ConstraintValidatorContext constraintValidatorContext) {
        return years == null || Arrays.stream(years).noneMatch(i -> i < 2015 || i > 2023);
    }
}
