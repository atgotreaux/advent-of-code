package com.gotreaux.aoc.puzzles.year2019.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CrossedWiresPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideClosestIntersection")
    void closestIntersection(String fileName, int expected) throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CrossedWiresPuzzle.class, fileName);

        CrossedWiresPuzzle puzzle = new CrossedWiresPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(expected, output.partOne());
    }

    private static Stream<Arguments> provideClosestIntersection() {
        return Stream.of(
                Arguments.of("ExampleOne.txt", 6),
                Arguments.of("ExampleTwo.txt", 159),
                Arguments.of("ExampleThree.txt", 135));
    }
}
