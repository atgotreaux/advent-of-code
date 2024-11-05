package com.gotreaux.aoc.puzzles.year2020.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PassportProcessingPuzzleTest {
    @Test
    void requiredFieldPassports() throws Exception {
        InputProvider inputProvider =
                new FileInputProvider<>(PassportProcessingPuzzle.class, "RequiredFields.txt");

        PassportProcessingPuzzle puzzle = new PassportProcessingPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(2, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideValidPassports")
    void validPassports(String fileName, int expected) throws Exception {
        InputProvider inputProvider =
                new FileInputProvider<>(PassportProcessingPuzzle.class, fileName);

        PassportProcessingPuzzle puzzle = new PassportProcessingPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(expected, output.partTwo());
    }

    private static Stream<Arguments> provideValidPassports() {
        return Stream.of(
                Arguments.of("InvalidPassports.txt", 0), Arguments.of("ValidPassports.txt", 4));
    }
}
