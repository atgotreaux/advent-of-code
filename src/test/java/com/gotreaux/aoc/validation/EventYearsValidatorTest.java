package com.gotreaux.aoc.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.validation.ConstraintValidatorContext;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

class EventYearsValidatorTest {
    @Mock ConstraintValidatorContext constraintValidatorContext;

    @ParameterizedTest
    @MethodSource("provideValidateYears")
    void validateYears(Integer[] years, boolean expectedValidity) {
        EventYearsValidator validator = new EventYearsValidator();

        assertEquals(expectedValidity, validator.isValid(years, constraintValidatorContext));
    }

    private static Stream<Arguments> provideValidateYears() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of(new Integer[0], true),
                Arguments.of(new Integer[] {2015}, true),
                Arguments.of(new Integer[] {2015, 2018, 2022}, true),
                Arguments.of(new Integer[] {2015, 2018, 2122}, false),
                Arguments.of(new Integer[] {2015, -2018, 2122}, false),
                Arguments.of(new Integer[] {2122}, false));
    }
}
