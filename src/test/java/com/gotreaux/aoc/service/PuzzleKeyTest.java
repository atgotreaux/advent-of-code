package com.gotreaux.aoc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PuzzleKeyTest {

    @Autowired private PuzzleService puzzleService;

    @Test
    void of() {
        var puzzle = puzzleService.getRandomPuzzle();

        var key = PuzzleKey.of(puzzle);

        assertEquals(puzzle.getYear(), key.year());
        assertEquals(puzzle.getDay(), key.day());
    }
}
