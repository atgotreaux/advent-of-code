package com.gotreaux.aoc.puzzles.year2021.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.DigitMatrixProvider;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SmokeBasinPuzzleTest {
    @Test
    void sumOfRiskLevels() {
        InputReader inputReader = new ResourceInputReader<>(SmokeBasinPuzzle.class);

        var puzzle = new SmokeBasinPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(15, output.partOne());
    }

    @Test
    void productOfLargestBasins() {
        InputReader inputReader = new ResourceInputReader<>(SmokeBasinPuzzle.class);

        var puzzle = new SmokeBasinPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(1134, output.partTwo());
    }

    @ParameterizedTest
    @MethodSource("provideBasinSize")
    void basinSize(Cell cell, int expectedSize) {
        InputReader inputReader = new ResourceInputReader<>(SmokeBasinPuzzle.class);

        var input = inputReader.getInputList();

        var matrix = new Matrix<>(input, new DigitMatrixProvider());

        assertEquals(expectedSize, SmokeBasinPuzzle.getBasinSize(matrix, cell));
    }

    private static Stream<Arguments> provideBasinSize() {
        return Stream.of(
                Arguments.of(new Cell(0, 1), 3),
                Arguments.of(new Cell(0, 9), 9),
                Arguments.of(new Cell(2, 2), 14),
                Arguments.of(new Cell(4, 6), 9));
    }
}
