package com.gotreaux.aoc.utils.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.year2022.day8.TreetopTreeHousePuzzle;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntMatrixTest {
    @ParameterizedTest
    @MethodSource("provideRowCount")
    void rowCount(Class<?> puzzleClass, int expectedRowCount) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        IntMatrix matrix = new IntMatrix(input);

        assertEquals(expectedRowCount, matrix.getRowCount());
    }

    @ParameterizedTest
    @MethodSource("provideColCount")
    void colCount(Class<?> puzzleClass, int expectedColCount) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        IntMatrix matrix = new IntMatrix(input);

        assertEquals(expectedColCount, matrix.getColCount());
    }

    @ParameterizedTest
    @MethodSource("provideGet")
    void get(Class<?> puzzleClass, int row, int col, int expected) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        IntMatrix matrix = new IntMatrix(input);

        assertEquals(expected, matrix.get(row, col));
    }

    @ParameterizedTest
    @MethodSource("provideUp")
    void up(Class<?> puzzleClass, int row, int col, Integer[] expected) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        IntMatrix matrix = new IntMatrix(input);

        assertArrayEquals(expected, matrix.up(row, col));
    }

    @ParameterizedTest
    @MethodSource("provideDown")
    void down(Class<?> puzzleClass, int row, int col, Integer[] expected) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        IntMatrix matrix = new IntMatrix(input);

        assertArrayEquals(expected, matrix.down(row, col));
    }

    @ParameterizedTest
    @MethodSource("provideLeft")
    void left(Class<?> puzzleClass, int row, int col, Integer[] expected) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        IntMatrix matrix = new IntMatrix(input);

        assertArrayEquals(expected, matrix.left(row, col));
    }

    @ParameterizedTest
    @MethodSource("provideRight")
    void right(Class<?> puzzleClass, int row, int col, Integer[] expected) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        IntMatrix matrix = new IntMatrix(input);

        assertArrayEquals(expected, matrix.right(row, col));
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
}
