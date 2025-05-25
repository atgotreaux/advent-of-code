package com.gotreaux.aoc.puzzles.year2024.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class PrintQueuePuzzleTest {

    @Test
    void sumOfCorrectOrders() {
        InputReader inputReader = new ResourceInputReader<>(PrintQueuePuzzle.class);

        var puzzle = new PrintQueuePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(143, output.partOne());
    }

    @Test
    void sumOfIncorrectOrders() {
        InputReader inputReader = new ResourceInputReader<>(PrintQueuePuzzle.class);

        var puzzle = new PrintQueuePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(123, output.partTwo());
    }
}
