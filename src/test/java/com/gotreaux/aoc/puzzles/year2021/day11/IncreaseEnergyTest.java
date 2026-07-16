package com.gotreaux.aoc.puzzles.year2021.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.DigitMatrixProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IncreaseEnergyTest {

    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(String inputFile, int steps, String expectedFile) {
        InputReader inputReader = new ResourceInputReader<>(DumboOctopusPuzzle.class, inputFile);
        var input = inputReader.getInputList();
        var inputGrid = new Matrix<>(input, new DigitMatrixProvider());

        InputReader expectedReader =
                new ResourceInputReader<>(DumboOctopusPuzzle.class, expectedFile);
        var expected = expectedReader.getInputList();
        var expectedGrid = new Matrix<>(expected, new DigitMatrixProvider());

        var increaseEnergy = new IncreaseEnergy();
        for (var step = 0; step < steps; step++) {
            inputGrid = increaseEnergy.apply(inputGrid);
        }

        assertEquals(expectedGrid, inputGrid);
    }

    private static Stream<Arguments> provideApply() {
        return Stream.of(
                Arguments.of("ExampleOne.txt", 1, "ExampleOneStepOne.txt"),
                Arguments.of("ExampleOne.txt", 2, "ExampleOneStepTwo.txt"),
                Arguments.of("input.txt", 1, "ExampleTwoStepOne.txt"),
                Arguments.of("input.txt", 2, "ExampleTwoStepTwo.txt"),
                Arguments.of("input.txt", 10, "ExampleTwoStepTen.txt"),
                Arguments.of("input.txt", 50, "ExampleTwoStepFifty.txt"));
    }
}
