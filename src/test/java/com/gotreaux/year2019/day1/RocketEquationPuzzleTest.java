package com.gotreaux.year2019.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.StringInputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RocketEquationPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideFuelRequirement")
    void fuelRequirement(String input, long expectedFuelRequirement) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(expectedFuelRequirement, puzzle.getPartOne());
    }

    @ParameterizedTest
    @MethodSource("provideAdditionalFuelRequirement")
    void additionalFuelRequirement(String input, long expectedFuelRequirement) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(expectedFuelRequirement, puzzle.getPartTwo());
    }

    private static Stream<Arguments> provideFuelRequirement() {
        return Stream.of(
                Arguments.of("12", 2L),
                Arguments.of("14", 2L),
                Arguments.of("1969", 654L),
                Arguments.of("100756", 33583L));
    }

    private static Stream<Arguments> provideAdditionalFuelRequirement() {
        return Stream.of(
                Arguments.of("12", 2L),
                Arguments.of("14", 2L),
                Arguments.of("1969", 966L),
                Arguments.of("100756", 50346L));
    }
}
