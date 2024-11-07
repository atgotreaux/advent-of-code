package com.gotreaux.aoc.puzzles.year2020.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinaryBoardingPuzzleTest {
    @Test
    void highestSeatID() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(BinaryBoardingPuzzle.class);

        BinaryBoardingPuzzle puzzle = new BinaryBoardingPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(820, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideSeatID")
    void seatID(CharSequence sequence, int expectedSeatID) {
        assertEquals(expectedSeatID, BinaryBoardingPuzzle.getSeatID(sequence));
    }

    private static Stream<Arguments> provideSeatID() {
        return Stream.of(
                Arguments.of("FBFBBFFRLR", 357),
                Arguments.of("BFFFBBFRRR", 567),
                Arguments.of("FFFBBBFRRR", 119),
                Arguments.of("BBFFBBFRLL", 820));
    }
}
