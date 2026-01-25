package com.gotreaux.aoc.utils.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2021.day9.SmokeBasinPuzzle;
import com.gotreaux.aoc.utils.matrix.navigator.NeighborsNavigator;
import com.gotreaux.aoc.utils.matrix.provider.DigitMatrixProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NeighborsNavigatorTest {

    @ParameterizedTest
    @MethodSource("provideCollectElements")
    void collectElements(Class<Puzzle> puzzleClass, Cell cell, List<Integer> expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = new Matrix<>(input, new DigitMatrixProvider());

        var navigator = new NeighborsNavigator<>(matrix, cell);

        assertEquals(expected, navigator.collectElements(Direction.cardinal()));
    }

    private static Stream<Arguments> provideCollectElements() {
        return Stream.of(
                Arguments.of(SmokeBasinPuzzle.class, new Cell(2, 4), List.of(8, 8, 8, 6)),
                Arguments.of(SmokeBasinPuzzle.class, new Cell(4, 2), List.of(6, 9, 8)),
                Arguments.of(SmokeBasinPuzzle.class, new Cell(0, 9), List.of(1, 1)));
    }
}
