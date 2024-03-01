package com.gotreaux.aoc.puzzles.year2015.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DinnerTablePuzzleTest {
    @Test
    void guestTableOptimalArrangement() throws Exception {
        InputProvider inputProvider = new FileInputProvider(DinnerTablePuzzleTest.class);

        DinnerTablePuzzle puzzle = new DinnerTablePuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(330, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideParseArrangement")
    void parseArrangement(String line, Arrangement expected) {
        Arrangement arrangement = DinnerTablePuzzle.parseArrangement(line);

        assertEquals(expected, arrangement);
    }

    private static Stream<Arguments> provideParseArrangement() {
        return Stream.of(
                Arguments.of(
                        "Alice would gain 54 happiness units by sitting next to Bob.",
                        new Arrangement("Alice", "Bob", 54)),
                Arguments.of(
                        "Alice would lose 79 happiness units by sitting next to Carol.",
                        new Arrangement("Alice", "Carol", -79)));
    }
}
