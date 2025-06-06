package com.gotreaux.aoc.puzzles.year2019.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RocketEquationPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideFuelRequirement")
    void fuelRequirement(String input, int expectedFuelRequirement) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new RocketEquationPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedFuelRequirement, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideAdditionalFuelRequirement")
    void additionalFuelRequirement(String input, int expectedFuelRequirement) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new RocketEquationPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedFuelRequirement, output.partTwo());
    }

    private static Stream<Arguments> provideFuelRequirement() {
        return Stream.of(
                Arguments.of("12", 2),
                Arguments.of("14", 2),
                Arguments.of("1969", 654),
                Arguments.of("100756", 33583));
    }

    private static Stream<Arguments> provideAdditionalFuelRequirement() {
        return Stream.of(
                Arguments.of("12", 2),
                Arguments.of("14", 2),
                Arguments.of("1969", 966),
                Arguments.of("100756", 50346));
    }
}
