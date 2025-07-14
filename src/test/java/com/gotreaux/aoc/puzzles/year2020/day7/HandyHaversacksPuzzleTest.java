package com.gotreaux.aoc.puzzles.year2020.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandyHaversacksPuzzleTest {

    @Test
    void containsShinyGoldBagCount() {
        InputReader inputReader =
                new ResourceInputReader<>(HandyHaversacksPuzzle.class, "ExampleOne.txt");

        var puzzle = new HandyHaversacksPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4L, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideBagCount")
    void shinyGoldBagCount(String fileName, long expectedBagCount) {
        InputReader inputReader = new ResourceInputReader<>(HandyHaversacksPuzzle.class, fileName);

        var puzzle = new HandyHaversacksPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedBagCount, output.partTwo());
    }

    private static Stream<Arguments> provideBagCount() {
        return Stream.of(Arguments.of("ExampleOne.txt", 32L), Arguments.of("ExampleTwo.txt", 126L));
    }
}
