package com.gotreaux.aoc.utils.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2021.day9.SmokeBasinPuzzle;
import com.gotreaux.aoc.puzzles.year2022.day8.TreetopTreeHousePuzzle;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntMatrixTest {
    @ParameterizedTest
    @MethodSource("provideRowCount")
    void rowCount(Class<Puzzle> puzzleClass, int expectedRowCount) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new IntMatrix(input);

        assertEquals(expectedRowCount, matrix.getRowCount());
    }

    @ParameterizedTest
    @MethodSource("provideColCount")
    void colCount(Class<Puzzle> puzzleClass, int expectedColCount) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new IntMatrix(input);

        assertEquals(expectedColCount, matrix.getColCount());
    }

    @ParameterizedTest
    @MethodSource("provideGet")
    void get(Class<Puzzle> puzzleClass, int row, int col, int expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new IntMatrix(input);

        assertEquals(expected, matrix.get(row, col));
    }

    @ParameterizedTest
    @MethodSource("provideUp")
    void up(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new IntMatrix(input);

        assertArrayEquals(expected, matrix.up(row, col));
    }

    @ParameterizedTest
    @MethodSource("provideDown")
    void down(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new IntMatrix(input);

        assertArrayEquals(expected, matrix.down(row, col));
    }

    @ParameterizedTest
    @MethodSource("provideLeft")
    void left(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new IntMatrix(input);

        assertArrayEquals(expected, matrix.left(row, col));
    }

    @ParameterizedTest
    @MethodSource("provideRight")
    void right(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new IntMatrix(input);

        assertArrayEquals(expected, matrix.right(row, col));
    }

    @ParameterizedTest
    @MethodSource("provideNeighbors")
    void neighbors(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new IntMatrix(input);

        assertArrayEquals(expected, matrix.neighbors(row, col));
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

    private static Stream<Arguments> provideUp() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, new Integer[] {0}),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, new Integer[] {3}),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, new Integer[] {5, 3}));
    }

    private static Stream<Arguments> provideDown() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, new Integer[] {5, 3, 5}),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, new Integer[] {3, 5, 3}),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, new Integer[] {5, 3}));
    }

    private static Stream<Arguments> provideLeft() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, new Integer[] {2}),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, new Integer[] {5, 2}),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, new Integer[] {5, 6}));
    }

    private static Stream<Arguments> provideRight() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, new Integer[] {5, 1, 2}),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, new Integer[] {1, 2}),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, new Integer[] {3, 2}));
    }

    private static Stream<Arguments> provideNeighbors() {
        return Stream.of(
                Arguments.of(SmokeBasinPuzzle.class, 2, 4, new Integer[] {8, 8, 6, 8}),
                Arguments.of(SmokeBasinPuzzle.class, 4, 2, new Integer[] {6, 8, 9}),
                Arguments.of(SmokeBasinPuzzle.class, 0, 9, new Integer[] {1, 1}));
    }
}
