package com.gotreaux.aoc.puzzles.year2015.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApartmentFloorPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideFloorFromInstructions")
    void floorFromInstructions(String input, int expectedFloor) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(expectedFloor, output.partOne());
    }

    @Test
    void positionBasementReached() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("()())");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(5, output.partTwo());
    }

    private static Stream<Arguments> provideFloorFromInstructions() {
        return Stream.of(
                Arguments.of("(())", 0),
                Arguments.of("()()", 0),
                Arguments.of("(((", 3),
                Arguments.of("(()(()(", 3),
                Arguments.of("))(((((", 3),
                Arguments.of("())", -1),
                Arguments.of("))(", -1),
                Arguments.of(")))", -3),
                Arguments.of(")())())", -3));
    }
}
