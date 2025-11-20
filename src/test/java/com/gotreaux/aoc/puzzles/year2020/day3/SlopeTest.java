package com.gotreaux.aoc.puzzles.year2020.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SlopeTest {
    @ParameterizedTest
    @MethodSource("provideTreesEncountered")
    void treesEncountered(int right, int down, int expectedTrees) {
        InputReader inputReader = new ResourceInputReader<>(TobogganTrajectoryPuzzle.class);

        var input = inputReader.getInputList();

        var matrix = MatrixFactory.ofChars(input);

        var slope = new Slope(right, down);

        assertEquals(expectedTrees, slope.getTreesEncountered(matrix));
    }

    private static Stream<Arguments> provideTreesEncountered() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(3, 1, 7),
                Arguments.of(5, 1, 3),
                Arguments.of(7, 1, 4),
                Arguments.of(1, 2, 2));
    }
}
