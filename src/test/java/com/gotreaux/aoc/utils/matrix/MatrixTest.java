package com.gotreaux.aoc.utils.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2022.day8.TreetopTreeHousePuzzle;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatrixTest {

    @ParameterizedTest
    @MethodSource("provideRowCount")
    void rowCount(Class<Puzzle> puzzleClass, int expectedRowCount) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofDigits(input);

        assertEquals(expectedRowCount, matrix.getRowCount());
    }

    @ParameterizedTest
    @MethodSource("provideColCount")
    void colCount(Class<Puzzle> puzzleClass, int expectedColCount) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofDigits(input);

        assertEquals(expectedColCount, matrix.getColCount());
    }

    @ParameterizedTest
    @MethodSource("provideGet")
    void get(Class<Puzzle> puzzleClass, int row, int col, int expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofDigits(input);

        assertEquals(expected, matrix.get(row, col));
    }

    private static Stream<Arguments> provideRowCount() {
        return Stream.of(Arguments.of(TreetopTreeHousePuzzle.class, 5));
    }

    private static Stream<Arguments> provideColCount() {
        return Stream.of(Arguments.of(TreetopTreeHousePuzzle.class, 5));
    }

    private static Stream<Arguments> provideGet() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 0, 3, 7),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 1, 5),
                Arguments.of(TreetopTreeHousePuzzle.class, 4, 4, 0));
    }
}
