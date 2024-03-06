package com.gotreaux.aoc.utils.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.year2020.day3.TobogganTrajectoryPuzzle;
import com.gotreaux.aoc.puzzles.year2023.day3.GearRatiosPuzzle;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CharMatrixTest {
    @ParameterizedTest
    @MethodSource("provideRowCount")
    void rowCount(Class<?> puzzleClass, int expectedRowCount) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        CharMatrix matrix = new CharMatrix(input);

        assertEquals(expectedRowCount, matrix.getRowCount());
    }

    @ParameterizedTest
    @MethodSource("provideColCount")
    void colCount(Class<?> puzzleClass, int expectedColCount) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        CharMatrix matrix = new CharMatrix(input);

        assertEquals(expectedColCount, matrix.getColCount());
    }

    @ParameterizedTest
    @MethodSource("provideGet")
    void get(Class<?> puzzleClass, int row, int col, char expectedChar) throws Exception {
        InputProvider inputProvider = new FileInputProvider(puzzleClass);

        List<String> input = inputProvider.getInputList();

        CharMatrix matrix = new CharMatrix(input);

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
