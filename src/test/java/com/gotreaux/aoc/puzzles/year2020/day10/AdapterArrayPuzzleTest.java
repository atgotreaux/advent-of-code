package com.gotreaux.aoc.puzzles.year2020.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AdapterArrayPuzzleTest {

    @ParameterizedTest
    @MethodSource("provideProductOfDifferences")
    void productOfDifferences(String fileName, int expectedProduct) {
        InputReader inputReader = new ResourceInputReader<>(AdapterArrayPuzzle.class, fileName);

        var puzzle = new AdapterArrayPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedProduct, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideNumberOfArrangements")
    void numberOfArrangements(String fileName, int expectedCount) {
        InputReader inputReader = new ResourceInputReader<>(AdapterArrayPuzzle.class, fileName);

        var puzzle = new AdapterArrayPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedCount, output.partTwo());
    }

    private static Stream<Arguments> provideProductOfDifferences() {
        return Stream.of(Arguments.of("ExampleOne.txt", 35), Arguments.of("ExampleTwo.txt", 220));
    }

    private static Stream<Arguments> provideNumberOfArrangements() {
        return Stream.of(Arguments.of("ExampleOne.txt", 8), Arguments.of("ExampleTwo.txt", 19208));
    }
}
