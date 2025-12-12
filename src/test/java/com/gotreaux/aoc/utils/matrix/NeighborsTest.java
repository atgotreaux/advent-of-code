package com.gotreaux.aoc.utils.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2021.day9.SmokeBasinPuzzle;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NeighborsTest {

    @ParameterizedTest
    @MethodSource("provideCollectElements")
    void collectElements(Class<Puzzle> puzzleClass, int row, int col, List<Integer> expected) {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofDigits(input);

        assertEquals(expected, Neighbors.collectElements(matrix, row, col, Direction.cardinal()));
    }

    private static Stream<Arguments> provideCollectElements() {
        return Stream.of(
                Arguments.of(SmokeBasinPuzzle.class, 2, 4, List.of(8, 8, 6, 8)),
                Arguments.of(SmokeBasinPuzzle.class, 4, 2, List.of(6, 8, 9)),
                Arguments.of(SmokeBasinPuzzle.class, 0, 9, List.of(1, 1)));
    }
}
