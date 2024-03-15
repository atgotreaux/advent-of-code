package com.gotreaux.aoc.puzzles.year2021.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.utils.matrix.IntMatrix;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SmokeBasinPuzzleTest {
    @Test
    void sumOfRiskLevels() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SmokeBasinPuzzle.class);

        SmokeBasinPuzzle puzzle = new SmokeBasinPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(15, output.partOne());
    }

    @Test
    void productOfLargestBasins() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SmokeBasinPuzzle.class);

        SmokeBasinPuzzle puzzle = new SmokeBasinPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(1134, output.partTwo());
    }

    @ParameterizedTest
    @MethodSource("provideBasinSize")
    void basinSize(int row, int col, int expectedSize) throws Exception {
        InputProvider inputProvider = new FileInputProvider(SmokeBasinPuzzle.class);

        List<String> input = inputProvider.getInputList();

        IntMatrix matrix = new IntMatrix(input);

        assertEquals(expectedSize, SmokeBasinPuzzle.getBasinSize(matrix, row, col));
    }

    private static Stream<Arguments> provideBasinSize() {
        return Stream.of(
                Arguments.of(0, 1, 3),
                Arguments.of(0, 9, 9),
                Arguments.of(2, 2, 14),
                Arguments.of(4, 6, 9)
        );
    }
}
