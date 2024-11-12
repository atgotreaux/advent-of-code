package com.gotreaux.aoc.puzzles.year2015.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
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
        InputReader inputReader = new StringInputReader(input);

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(expectedFloor, output.partOne());
    }

    @Test
    void positionBasementReached() throws Exception {
        InputReader inputReader = new StringInputReader("()())");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

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
