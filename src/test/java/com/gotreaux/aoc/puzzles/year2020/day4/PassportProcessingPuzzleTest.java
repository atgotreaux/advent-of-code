package com.gotreaux.aoc.puzzles.year2020.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PassportProcessingPuzzleTest {
    @Test
    void requiredFieldPassports() {
        InputReader inputReader =
                new ResourceInputReader<>(PassportProcessingPuzzle.class, "RequiredFields.txt");

        var puzzle = new PassportProcessingPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(2, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideValidPassports")
    void validPassports(String fileName, int expected) {
        InputReader inputReader =
                new ResourceInputReader<>(PassportProcessingPuzzle.class, fileName);

        var puzzle = new PassportProcessingPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partTwo());
    }

    private static Stream<Arguments> provideValidPassports() {
        return Stream.of(
                Arguments.of("InvalidPassports.txt", 0), Arguments.of("ValidPassports.txt", 4));
    }
}
