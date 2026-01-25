package com.gotreaux.aoc.utils.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2022.day8.TreetopTreeHousePuzzle;
import com.gotreaux.aoc.utils.matrix.navigator.RayNavigator;
import com.gotreaux.aoc.utils.matrix.provider.DigitMatrixProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RayNavigatorTest {

    @ParameterizedTest
    @MethodSource("provideNorth")
    void north(Class<Puzzle> puzzleClass, int row, int col, List<Integer> expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new Matrix<>(input, new DigitMatrixProvider());

        var navigator = new RayNavigator<>(matrix, new Cell(row, col));

        assertEquals(expected, navigator.collectElements(Direction.NORTH));
    }

    @ParameterizedTest
    @MethodSource("provideSouth")
    void south(Class<Puzzle> puzzleClass, int row, int col, List<Integer> expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new Matrix<>(input, new DigitMatrixProvider());

        var navigator = new RayNavigator<>(matrix, new Cell(row, col));

        assertEquals(expected, navigator.collectElements(Direction.SOUTH));
    }

    @ParameterizedTest
    @MethodSource("provideWest")
    void west(Class<Puzzle> puzzleClass, int row, int col, List<Integer> expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new Matrix<>(input, new DigitMatrixProvider());

        var navigator = new RayNavigator<>(matrix, new Cell(row, col));

        assertEquals(expected, navigator.collectElements(Direction.WEST));
    }

    @ParameterizedTest
    @MethodSource("provideEast")
    void east(Class<Puzzle> puzzleClass, int row, int col, List<Integer> expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new Matrix<>(input, new DigitMatrixProvider());

        var navigator = new RayNavigator<>(matrix, new Cell(row, col));

        assertEquals(expected, navigator.collectElements(Direction.EAST));
    }

    private static Stream<Arguments> provideNorth() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, List.of(0)),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, List.of(3)),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, List.of(5, 3)));
    }

    private static Stream<Arguments> provideSouth() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, List.of(5, 3, 5)),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, List.of(3, 5, 3)),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, List.of(5, 3)));
    }

    private static Stream<Arguments> provideWest() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, List.of(2)),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, List.of(5, 2)),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, List.of(5, 6)));
    }

    private static Stream<Arguments> provideEast() {
        return Stream.of(
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 1, List.of(5, 1, 2)),
                Arguments.of(TreetopTreeHousePuzzle.class, 1, 2, List.of(1, 2)),
                Arguments.of(TreetopTreeHousePuzzle.class, 2, 2, List.of(3, 2)));
    }
}
