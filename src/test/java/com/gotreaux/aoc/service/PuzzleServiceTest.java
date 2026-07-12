package com.gotreaux.aoc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.exceptions.NoSuchPuzzleException;
import com.gotreaux.aoc.puzzles.year2015.day1.ApartmentFloorPuzzle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PuzzleServiceTest {

    @Autowired private PuzzleService puzzleService;

    @Test
    void returnsMatchingPuzzle() {
        var expected = new ApartmentFloorPuzzle();

        var puzzle = puzzleService.getPuzzle(expected.getYear(), expected.getDay());

        assertEquals(expected.getYear(), puzzle.getYear());
        assertEquals(expected.getDay(), puzzle.getDay());
    }

    @Test
    void throwsForInvalidYear() {
        assertThrows(NoSuchPuzzleException.class, () -> puzzleService.getPuzzle(1900, 1));
    }

    @Test
    void throwsForInvalidDay() {
        assertThrows(NoSuchPuzzleException.class, () -> puzzleService.getPuzzle(2015, 26));
    }

    @Test
    void randomReturnsNonNull() {
        assertNotNull(puzzleService.getRandomPuzzle());
    }
}
