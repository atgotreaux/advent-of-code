package com.gotreaux.aoc.puzzles.year2025.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class CafeteriaPuzzleTest {

    @Test
    void numberOfFreshIngredients() {
        InputReader inputReader = new ResourceInputReader<>(CafeteriaPuzzle.class);

        var puzzle = new CafeteriaPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(3, output.partOne());
    }

    @Test
    void totalFreshIngredientSize() {
        InputReader inputReader = new ResourceInputReader<>(CafeteriaPuzzle.class);

        var puzzle = new CafeteriaPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(14L, output.partTwo());
    }
}
