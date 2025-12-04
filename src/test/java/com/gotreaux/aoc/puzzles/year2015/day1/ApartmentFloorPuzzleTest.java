package com.gotreaux.aoc.puzzles.year2015.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApartmentFloorPuzzleTest {

    @ParameterizedTest
    @MethodSource("provideFloorFromInstructions")
    void floorFromInstructions(String input, int expectedFloor) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new ApartmentFloorPuzzle();

        assertEquals(expectedFloor, puzzle.solvePartOne(inputReader));
    }

    @Test
    void positionBasementReached() {
        InputReader inputReader = new StringInputReader("()())");

        var puzzle = new ApartmentFloorPuzzle();

        assertEquals(5, puzzle.solvePartTwo(inputReader));
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
