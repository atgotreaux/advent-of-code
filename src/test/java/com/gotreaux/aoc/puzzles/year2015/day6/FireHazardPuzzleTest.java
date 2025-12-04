package com.gotreaux.aoc.puzzles.year2015.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FireHazardPuzzleTest {

    @ParameterizedTest
    @MethodSource("provideLightsLit")
    void lightsLit(String input, int expectedLights) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new FireHazardPuzzle();

        assertEquals(expectedLights, puzzle.solvePartOne(inputReader));
    }

    @ParameterizedTest
    @MethodSource("provideBrightnessLit")
    void brightnessLit(String input, int expectedLights) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new FireHazardPuzzle();

        assertEquals(expectedLights, puzzle.solvePartTwo(inputReader));
    }

    private static Stream<Arguments> provideLightsLit() {
        return Stream.of(
                Arguments.of("turn on 0,0 through 999,999", 1000000),
                Arguments.of("toggle 0,0 through 999,0", 1000),
                Arguments.of("turn off 499,499 through 500,500", 0));
    }

    private static Stream<Arguments> provideBrightnessLit() {
        return Stream.of(
                Arguments.of("turn on 0,0 through 0,0", 1),
                Arguments.of("toggle 0,0 through 999,999", 2000000));
    }
}
