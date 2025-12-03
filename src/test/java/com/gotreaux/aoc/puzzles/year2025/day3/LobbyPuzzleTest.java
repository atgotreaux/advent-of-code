package com.gotreaux.aoc.puzzles.year2025.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class LobbyPuzzleTest {

    @Test
    void sumOfTwoBatteryMaxJoltage() {
        InputReader inputReader = new ResourceInputReader<>(LobbyPuzzle.class);

        var puzzle = new LobbyPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(357L, output.partOne());
    }

    @Test
    void sumOfTwelveBatteryMaxJoltage() {
        InputReader inputReader = new ResourceInputReader<>(LobbyPuzzle.class);

        var puzzle = new LobbyPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(3121910778619L, output.partTwo());
    }
}
