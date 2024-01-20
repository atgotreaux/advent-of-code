package com.gotreaux.aoc.services;

import static org.junit.jupiter.api.Assertions.*;

import com.gotreaux.aoc.dto.PuzzleDto;
import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleServiceTest {
    @Test
    void everyPuzzle() throws Exception {
        List<PuzzleDto> puzzles = PuzzleService.getPuzzles(List.of(), List.of());

        assertEquals(29, puzzles.size());
    }

    @Test
    void everyPuzzleForYear() throws Exception {
        // TODO once all puzzles are solved, a random year should return 25 puzzles
        List<PuzzleDto> puzzles = PuzzleService.getPuzzles(List.of(2015), List.of());

        assertEquals(5, puzzles.size());
        for (PuzzleDto puzzle : puzzles) {
            assertEquals(2015, puzzle.year());
        }
    }

    @Test
    void everyPuzzleForDay() throws Exception {
        // TODO once all puzzles are solved, a random day should return 9 puzzles
        List<PuzzleDto> puzzles = PuzzleService.getPuzzles(List.of(), List.of(1));

        assertEquals(9, puzzles.size());
        for (PuzzleDto puzzle : puzzles) {
            assertEquals(1, puzzle.day());
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
