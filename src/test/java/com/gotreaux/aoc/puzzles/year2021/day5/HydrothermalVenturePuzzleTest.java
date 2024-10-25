package com.gotreaux.aoc.puzzles.year2021.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HydrothermalVenturePuzzleTest {
    @Test
    void overlappingOrthogonalPoints() throws Exception {
        InputProvider inputProvider = new FileInputProvider(HydrothermalVenturePuzzle.class);

        HydrothermalVenturePuzzle puzzle = new HydrothermalVenturePuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(5L, output.partOne());
    }

    @Test
    void allOverlappingPoints() throws Exception {
        InputProvider inputProvider = new FileInputProvider(HydrothermalVenturePuzzle.class);

        HydrothermalVenturePuzzle puzzle = new HydrothermalVenturePuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(12L, output.partTwo());
    }

    @ParameterizedTest
    @MethodSource("provideParseLine")
    void parseLine(String input, Line expected) {
        Line line = HydrothermalVenturePuzzle.parseLine(input);

        assertEquals(expected, line);
    }

    private static Stream<Arguments> provideParseLine() {
        return Stream.of(
                Arguments.of("0,9 -> 5,9", new Line(0, 9, 5, 9)),
                Arguments.of("8,0 -> 0,8", new Line(8, 0, 0, 8)),
                Arguments.of("6,4 -> 2,0", new Line(6, 4, 2, 0)));
    }
}
