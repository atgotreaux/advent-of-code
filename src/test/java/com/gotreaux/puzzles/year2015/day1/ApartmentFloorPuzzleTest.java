package com.gotreaux.puzzles.year2015.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.StringInputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApartmentFloorPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideFloorFromInstructions")
    void floorFromInstructions(String input, long expectedFloor) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(expectedFloor, puzzle.getPartOne());
    }

    @ParameterizedTest
    @MethodSource("providePositionBasementReached")
    void positionBasementReached(String input, int expectedFloor) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(expectedFloor, puzzle.getPartTwo());
    }

    private static Stream<Arguments> provideFloorFromInstructions() {
        return Stream.of(
                Arguments.of("(())", 0L),
                Arguments.of("()()", 0L),
                Arguments.of("(((", 3L),
                Arguments.of("(()(()(", 3L),
                Arguments.of("))(((((", 3L),
                Arguments.of("())", -1L),
                Arguments.of("))(", -1L),
                Arguments.of(")))", -3L),
                Arguments.of(")())())", -3L));
    }

    private static Stream<Arguments> providePositionBasementReached() {
        return Stream.of(Arguments.of(")", 1), Arguments.of("()())", 5));
    }
}
