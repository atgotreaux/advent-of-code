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

    @ParameterizedTest
    @MethodSource("provideNorth")
    void north(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofDigits(input);

        assertArrayEquals(expected, matrix.elementsInDirection(row, col, Direction.NORTH));
    }

    @ParameterizedTest
    @MethodSource("provideSouth")
    void south(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofDigits(input);

        assertArrayEquals(expected, matrix.elementsInDirection(row, col, Direction.SOUTH));
    }

    @ParameterizedTest
    @MethodSource("provideWest")
    void west(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofDigits(input);

        assertArrayEquals(expected, matrix.elementsInDirection(row, col, Direction.WEST));
    }

    @ParameterizedTest
    @MethodSource("provideEast")
    void east(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofDigits(input);

        assertArrayEquals(expected, matrix.elementsInDirection(row, col, Direction.EAST));
    }

    @ParameterizedTest
    @MethodSource("provideNeighbors")
    void neighbors(Class<Puzzle> puzzleClass, int row, int col, Integer[] expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofDigits(input);

        assertArrayEquals(expected, matrix.neighbors(row, col, Direction.cardinalDirections()));
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

    private static Stream<Arguments> provideNorth() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, new Integer[] {0}),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, new Integer[] {3}),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, new Integer[] {5, 3}));
    }

    private static Stream<Arguments> provideSouth() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, new Integer[] {5, 3, 5}),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, new Integer[] {3, 5, 3}),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, new Integer[] {5, 3}));
    }

    private static Stream<Arguments> provideWest() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, new Integer[] {2}),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, new Integer[] {5, 2}),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, new Integer[] {5, 6}));
    }

    private static Stream<Arguments> provideEast() {
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
