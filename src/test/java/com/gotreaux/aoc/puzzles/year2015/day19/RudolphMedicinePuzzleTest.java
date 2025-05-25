package com.gotreaux.aoc.puzzles.year2015.day19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RudolphMedicinePuzzleTest {

    @ParameterizedTest
    @MethodSource("provideCalibrationMolecules")
    void calibrationMolecules(String fileName, int expected) {
        InputReader inputReader = new ResourceInputReader<>(RudolphMedicinePuzzle.class, fileName);

        var puzzle = new RudolphMedicinePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideStepsToFabricate")
    void stepsToFabricate(String fileName, int expected) {
        InputReader inputReader = new ResourceInputReader<>(RudolphMedicinePuzzle.class, fileName);

        var puzzle = new RudolphMedicinePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partTwo());
    }

    private static Stream<Arguments> provideCalibrationMolecules() {
        return Stream.of(Arguments.of("ExampleOne.txt", 4), Arguments.of("ExampleTwo.txt", 7));
    }

    private static Stream<Arguments> provideStepsToFabricate() {
        return Stream.of(Arguments.of("ExampleThree.txt", 3), Arguments.of("ExampleFour.txt", 6));
    }
}
