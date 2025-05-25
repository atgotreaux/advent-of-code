package com.gotreaux.aoc.puzzles.year2016.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CyberspaceExplosivesPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideDecompressedLength")
    void decompressedLength(String input, long expected) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new CyberspaceExplosivesPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideDecompressedRecursiveLength")
    void decompressedRecursiveLength(String input, long expected) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new CyberspaceExplosivesPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partTwo());
    }

    private static Stream<Arguments> provideDecompressedLength() {
        return Stream.of(
                Arguments.of("ADVENT", 6L),
                Arguments.of("A(1x5)BC", 7L),
                Arguments.of("(3x3)XYZ", 9L),
                Arguments.of("A(2x2)BCD(2x2)EFG", 11L),
                Arguments.of("(6x1)(1x3)A", 6L),
                Arguments.of("X(8x2)(3x3)ABCY", 18L));
    }

    private static Stream<Arguments> provideDecompressedRecursiveLength() {
        return Stream.of(
                Arguments.of("(3x3)XYZ", 9L),
                Arguments.of("X(8x2)(3x3)ABCY", 20L),
                Arguments.of("(27x12)(20x12)(13x14)(7x10)(1x12)A", 241920L),
                Arguments.of("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN", 445L));
    }
}
