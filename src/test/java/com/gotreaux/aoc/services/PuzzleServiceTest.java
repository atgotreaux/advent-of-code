package com.gotreaux.aoc.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.dto.PuzzleDto;
import java.util.List;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class PuzzleServiceTest {
    @Test
    void everyPuzzle() throws Exception {
        List<PuzzleDto> puzzles = PuzzleService.getPuzzles(List.of(), List.of());

        assertEquals(42, puzzles.size());
    }

    @Test
    void everyPuzzleForYear() throws Exception {
        // TODO once all puzzles are solved, a random year should return 25 puzzles
        List<PuzzleDto> puzzles = PuzzleService.getPuzzles(List.of(2015), List.of());

        assertEquals(8, puzzles.size());
        for (PuzzleDto puzzle : puzzles) {
            assertEquals(2015, puzzle.year());
        }
    }

    @Test
    void everyPuzzleForDay() throws Exception {
        // TODO once all puzzles are solved, a random day should return 9 puzzles
        RandomGenerator generator = RandomGenerator.getDefault();

        int day = generator.nextInt(1, 3);

        List<PuzzleDto> puzzles = PuzzleService.getPuzzles(List.of(), List.of(day));

        assertEquals(9, puzzles.size());
        for (PuzzleDto puzzle : puzzles) {
            assertEquals(day, puzzle.day());
        }
    }

    @Test
    void onePuzzleForDayAndYear() throws Exception {
        // TODO once all puzzles are solved, pick random day and year in valid range
        List<PuzzleDto> puzzles = PuzzleService.getPuzzles(List.of(2015), List.of(1));

        assertEquals(1, puzzles.size());
        for (PuzzleDto puzzle : puzzles) {
            assertEquals(2015, puzzle.year());
            assertEquals(1, puzzle.day());
        }
    }
}
