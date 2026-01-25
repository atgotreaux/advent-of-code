package com.gotreaux.aoc.puzzles.year2020.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.CharMatrixProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ModelArrivalFunctionTest {

    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(int rounds, String expectedLayoutFile) {
        InputReader inputReader = new ResourceInputReader<>(SeatingSystemPuzzle.class);
        var input = inputReader.getInputList();
        var matrix = new Matrix<>(input, new CharMatrixProvider());

        var modelArrivalFunction = new ModelArrivalFunction();
        for (var round = 0; round < rounds; round++) {
            matrix = modelArrivalFunction.apply(matrix);
        }

        InputReader expectedOutputReader =
                new ResourceInputReader<>(SeatingSystemPuzzle.class, expectedLayoutFile);
        var expectedOutput = expectedOutputReader.getInputList();
        var expectedMatrix = new Matrix<>(expectedOutput, new CharMatrixProvider());

        assertEquals(expectedMatrix, matrix);
    }

    private static Stream<Arguments> provideApply() {
        return Stream.of(
                Arguments.of(1, "OneRound.txt"),
                Arguments.of(2, "TwoRounds.txt"),
                Arguments.of(3, "ThreeRounds.txt"),
                Arguments.of(4, "FourRounds.txt"),
                Arguments.of(5, "FiveRounds.txt"));
    }
}
