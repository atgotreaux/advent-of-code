package com.gotreaux.puzzles.year2015.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.StringInputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SphericalHousesPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideHouseDeliveries")
    void houseDeliveries(String input, int expectedDeliveries) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle(inputProvider);

        assertEquals(expectedDeliveries, puzzle.getPartOne());
    }

    @ParameterizedTest
    @MethodSource("provideAssistedHouseDeliveries")
    void assistedHouseDeliveries(String input, int expectedDeliveries) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle(inputProvider);

        assertEquals(expectedDeliveries, puzzle.getPartTwo());
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
