package com.gotreaux.aoc.puzzles.year2015.day6;

import static org.junit.jupiter.api.Assertions.*;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FireHazardPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideLightsLit")
    void lightsLit(String input, int expectedLights) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        FireHazardPuzzle puzzle = new FireHazardPuzzle(inputProvider);

        PuzzleOutput<Long, Integer> output = puzzle.solve();

        assertEquals(expectedLights, output.partOne());
    }

    private static Stream<Arguments> provideLightsLit() {
        return Stream.of(
                Arguments.of("turn on 0,0 through 999,999", 1000000),
                Arguments.of("toggle 0,0 through 999,0", 1000),
                Arguments.of("turn off 499,499 through 500,500", 0));
    }
}
