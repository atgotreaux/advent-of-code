package com.gotreaux.aoc.utils.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2020.day3.TobogganTrajectoryPuzzle;
import com.gotreaux.aoc.puzzles.year2023.day3.GearRatiosPuzzle;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CharMatrixTest {
    @ParameterizedTest
    @MethodSource("provideRowCount")
    void rowCount(Class<Puzzle> puzzleClass, int expectedRowCount) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new CharMatrix(input);

        assertEquals(expectedRowCount, matrix.getRowCount());
    }

    @ParameterizedTest
    @MethodSource("provideColCount")
    void colCount(Class<Puzzle> puzzleClass, int expectedColCount) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new CharMatrix(input);

        assertEquals(expectedColCount, matrix.getColCount());
    }

    @ParameterizedTest
    @MethodSource("provideGet")
    void get(Class<Puzzle> puzzleClass, int row, int col, char expectedChar) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new CharMatrix(input);

        assertEquals(expectedChar, matrix.get(row, col));
    }

    private static Stream<Arguments> provideRowCount() {
        return Stream.of(
                Arguments.of(GearRatiosPuzzle.class, 10),
                Arguments.of(TobogganTrajectoryPuzzle.class, 11));
    }

    private static Stream<Arguments> provideColCount() {
        return Stream.of(
                Arguments.of(GearRatiosPuzzle.class, 10),
                Arguments.of(TobogganTrajectoryPuzzle.class, 11));
    }

    private static Stream<Arguments> provideGet() {
        return Stream.of(
                Arguments.of(GearRatiosPuzzle.class, 0, 7, '4'),
                Arguments.of(GearRatiosPuzzle.class, 6, 9, '.'),
                Arguments.of(GearRatiosPuzzle.class, 8, 5, '*'),
                Arguments.of(TobogganTrajectoryPuzzle.class, 5, 10, '.'),
                Arguments.of(TobogganTrajectoryPuzzle.class, 9, 3, '.'),
                Arguments.of(TobogganTrajectoryPuzzle.class, 2, 6, '#'));
    }
}
