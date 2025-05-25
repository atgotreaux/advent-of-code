package com.gotreaux.aoc.puzzles.year2015.day20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InfiniteElvesPuzzleTest {

    @ParameterizedTest
    @MethodSource("provideMinimumHouseNumber")
    void minimumHouseNumber(int presentTarget, int expectedMinimumHouseNumber) {
        InputReader inputReader = new StringInputReader(String.valueOf(presentTarget));

        var puzzle = new InfiniteElvesPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedMinimumHouseNumber, output.partOne());
    }

    private static Stream<Arguments> provideMinimumHouseNumber() {
        return Stream.of(
                Arguments.of(10, 1),
                Arguments.of(30, 2),
                Arguments.of(40, 3),
                Arguments.of(70, 4),
                Arguments.of(120, 6),
                Arguments.of(150, 8));
    }
}
