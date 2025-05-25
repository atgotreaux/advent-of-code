package com.gotreaux.aoc.puzzles.year2018.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ChronalCalibrationPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideResultingFrequency")
    void resultingFrequency(String fileName, int expectedFrequency) {
        InputReader inputReader =
                new ResourceInputReader<>(ChronalCalibrationPuzzle.class, fileName);

        var puzzle = new ChronalCalibrationPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedFrequency, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideFirstDuplicateFrequency")
    void firstDuplicateFrequency(String fileName, int expectedFrequency) {
        InputReader inputReader =
                new ResourceInputReader<>(ChronalCalibrationPuzzle.class, fileName);

        var puzzle = new ChronalCalibrationPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedFrequency, output.partTwo());
    }

    private static Stream<Arguments> provideResultingFrequency() {
        return Stream.of(
                // Arguments.of("ExampleOne.txt", 3),
                Arguments.of("ExampleTwo.txt", 0));
        // Arguments.of("ExampleThree.txt", -6));
    }

    private static Stream<Arguments> provideFirstDuplicateFrequency() {
        return Stream.of(
                Arguments.of("ExampleFour.txt", 0),
                Arguments.of("ExampleFive.txt", 10),
                Arguments.of("ExampleSix.txt", 5),
                Arguments.of("ExampleSeven.txt", 14));
    }
}
