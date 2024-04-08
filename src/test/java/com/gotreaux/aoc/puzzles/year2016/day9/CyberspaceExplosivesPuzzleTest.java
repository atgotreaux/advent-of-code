package com.gotreaux.aoc.puzzles.year2016.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CyberspaceExplosivesPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideDecompressedLength")
    void decompressedLength(String input, int expected) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        CyberspaceExplosivesPuzzle puzzle = new CyberspaceExplosivesPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(expected, output.partOne());
    }

    private static Stream<Arguments> provideDecompressedLength() {
        return Stream.of(
                Arguments.of("ADVENT", 6),
                Arguments.of("A(1x5)BC", 7),
                Arguments.of("(3x3)XYZ", 9),
                Arguments.of("A(2x2)BCD(2x2)EFG", 11),
                Arguments.of("(6x1)(1x3)A", 6),
                Arguments.of("X(8x2)(3x3)ABCY", 18));
    }
}
