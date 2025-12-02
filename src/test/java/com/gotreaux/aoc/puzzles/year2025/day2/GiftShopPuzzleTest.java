package com.gotreaux.aoc.puzzles.year2025.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class GiftShopPuzzleTest {

    @Test
    void sumOfIdsRepeatingTwice() {
        InputReader inputReader = new ResourceInputReader<>(GiftShopPuzzle.class);

        var puzzle = new GiftShopPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(1227775554L, output.partOne());
    }

    @Test
    void sumOfIdsRepeatingAtLeastTwice() {
        InputReader inputReader = new ResourceInputReader<>(GiftShopPuzzle.class);

        var puzzle = new GiftShopPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4174379265L, output.partTwo());
    }
}
