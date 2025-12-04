package com.gotreaux.aoc.puzzles.year2025.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RemoveRollsFunctionTest {

    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(int rounds, String expectedGridFile) {
        InputReader inputReader = new ResourceInputReader<>(PrintingDepartmentPuzzle.class);
        var input = inputReader.getInputList();
        var grid = MatrixFactory.ofChars(input);

        var removeRolls = new RemoveRollsFunction();
        for (var round = 0; round < rounds; round++) {
            grid = removeRolls.apply(grid);
        }

        InputReader expectedOutputReader =
                new ResourceInputReader<>(PrintingDepartmentPuzzle.class, expectedGridFile);
        var expectedOutput = expectedOutputReader.getInputList();
        var expectedGrid = MatrixFactory.ofChars(expectedOutput);

        assertEquals(expectedGrid, grid);
    }

    private static Stream<Arguments> provideApply() {
        return Stream.of(
                Arguments.of(1, "OneRound.txt"),
                Arguments.of(3, "ThreeRounds.txt"),
                Arguments.of(9, "NineRounds.txt"));
    }
}
