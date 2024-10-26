package com.gotreaux.aoc.validation;

import com.gotreaux.aoc.annotations.ElementsInRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import org.springframework.lang.Nullable;

public class ElementsInRangeValidator implements ConstraintValidator<ElementsInRange, Integer[]> {

    private int min;
    private int max;

    @Override
    public void initialize(ElementsInRange constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(
            @Nullable Integer[] elements, ConstraintValidatorContext constraintValidatorContext) {
        return elements == null || Arrays.stream(elements).allMatch(i -> i >= min && i <= max);
    }
}
