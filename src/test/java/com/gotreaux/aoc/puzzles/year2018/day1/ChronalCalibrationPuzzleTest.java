package com.gotreaux.aoc.puzzles.year2018.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ChronalCalibrationPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideResultingFrequency")
    void resultingFrequency(String fileName, long expectedFrequency) throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(ChronalCalibrationPuzzle.class, fileName);

        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle(inputProvider);

        assertEquals(expectedFrequency, puzzle.getPartOne());
    }

    @ParameterizedTest
    @MethodSource("provideFirstDuplicateFrequency")
    void firstDuplicateFrequency(String fileName, long expectedFrequency) throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(ChronalCalibrationPuzzle.class, fileName);

        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle(inputProvider);

        assertEquals(expectedFrequency, puzzle.getPartTwo());
    }

    private static Stream<Arguments> provideResultingFrequency() {
        return Stream.of(
                Arguments.of("ExampleOne.txt", 3L),
                Arguments.of("ExampleTwo.txt", 0L),
                Arguments.of("ExampleThree.txt", -6L));
    }

    private static Stream<Arguments> provideFirstDuplicateFrequency() {
        return Stream.of(
                Arguments.of("ExampleFour.txt", 0L),
                Arguments.of("ExampleFive.txt", 10L),
                Arguments.of("ExampleSix.txt", 5L),
                Arguments.of("ExampleSeven.txt", 14L));
    }
}
