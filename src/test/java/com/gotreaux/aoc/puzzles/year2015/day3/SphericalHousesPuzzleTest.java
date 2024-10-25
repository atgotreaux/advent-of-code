package com.gotreaux.aoc.puzzles.year2015.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SphericalHousesPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideHouseDeliveries")
    void houseDeliveries(String input, int expectedDeliveries) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(expectedDeliveries, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideAssistedHouseDeliveries")
    void assistedHouseDeliveries(String input, int expectedDeliveries) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(expectedDeliveries, output.partTwo());
    }

    private static Stream<Arguments> provideHouseDeliveries() {
        return Stream.of(
                Arguments.of(">", 2), Arguments.of("^>v<", 4), Arguments.of("^v^v^v^v^v", 2));
    }

    private static Stream<Arguments> provideAssistedHouseDeliveries() {
        return Stream.of(
                Arguments.of("^v", 3), Arguments.of("^>v<", 3), Arguments.of("^v^v^v^v^v", 11));
    }
}
