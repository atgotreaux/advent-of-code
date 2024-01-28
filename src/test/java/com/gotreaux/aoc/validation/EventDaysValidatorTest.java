package com.gotreaux.aoc.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.validation.ConstraintValidatorContext;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.springframework.lang.Nullable;

class EventDaysValidatorTest {
    @Mock ConstraintValidatorContext constraintValidatorContext;

    @ParameterizedTest
    @MethodSource("provideValidateDays")
    void validateDays(@Nullable Integer[] days, boolean expectedValidity) {
        EventDaysValidator validator = new EventDaysValidator();

        assertEquals(expectedValidity, validator.isValid(days, constraintValidatorContext));
    }

    private static Stream<Arguments> provideValidateDays() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of(new Integer[0], true),
                Arguments.of(new Integer[] {13}, true),
                Arguments.of(new Integer[] {1, 10, 20}, true),
                Arguments.of(new Integer[] {1, 10, 26}, false),
                Arguments.of(new Integer[] {1, -10, 26}, false),
                Arguments.of(new Integer[] {26}, false));
    }
}
