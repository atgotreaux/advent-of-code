package com.gotreaux.aoc.puzzles.year2019.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CrossedWiresPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideClosestIntersectionDistance")
    void closestIntersectionDistance(String fileName, int expected) throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CrossedWiresPuzzle.class, fileName);

        CrossedWiresPuzzle puzzle = new CrossedWiresPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(expected, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideClosestIntersectionSteps")
    void closestIntersectionSteps(String fileName, int expected) throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CrossedWiresPuzzle.class, fileName);

        CrossedWiresPuzzle puzzle = new CrossedWiresPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(expected, output.partTwo());
    }

    private static Stream<Arguments> provideClosestIntersectionDistance() {
        return Stream.of(
                Arguments.of("ExampleOne.txt", 6),
                Arguments.of("ExampleTwo.txt", 159),
                Arguments.of("ExampleThree.txt", 135));
    }

    private static Stream<Arguments> provideClosestIntersectionSteps() {
        return Stream.of(
                Arguments.of("ExampleOne.txt", 30),
                Arguments.of("ExampleTwo.txt", 610),
                Arguments.of("ExampleThree.txt", 410));
    }
}
