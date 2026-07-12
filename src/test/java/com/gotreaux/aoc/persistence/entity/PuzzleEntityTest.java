package com.gotreaux.aoc.persistence.entity;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.service.PuzzleService;
import java.util.random.RandomGenerator;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class PuzzleEntityTest {
    @Autowired private PuzzleService puzzleService;

    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void throwsIfEmpty() {
        var puzzleEntity = new PuzzleEntity();

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfEmptyYear() {
        var puzzle = puzzleService.getRandomPuzzle();

        var input = RandomString.make(10);

        var puzzleEntity = new PuzzleEntity(null, puzzle.getDay(), input);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfEmptyDay() {
        var puzzle = puzzleService.getRandomPuzzle();

        var input = RandomString.make(10);

        var puzzleEntity = new PuzzleEntity(puzzle.getYear(), null, input);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfEmptyInput() {
        var puzzle = puzzleService.getRandomPuzzle();

        var puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), null);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfInvalidYear() {
        var puzzle = puzzleService.getRandomPuzzle();

        var input = RandomString.make(10);

        var puzzleEntity =
                new PuzzleEntity(
                        RandomGenerator.getDefault().nextInt(2015), puzzle.getDay(), input);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfInvalidDay() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzleService.getRandomPuzzle();

        var input = RandomString.make(10);

        var puzzleEntity = new PuzzleEntity(puzzle.getYear(), generator.nextInt(26, 32), input);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    @DirtiesContext
    void doesNotInsertIfDuplicate() {
        var puzzle = puzzleService.getRandomPuzzle();

        var input = RandomString.make(10);

        var puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);
        var duplicatePuzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);

        puzzleRepository.save(puzzleEntity);
        puzzleRepository.save(duplicatePuzzleEntity);

        assertEquals(1L, puzzleRepository.count());
    }

    @Test
    @DirtiesContext
    void doesNotThrowIfValid() {
        var puzzle = puzzleService.getRandomPuzzle();

        var input = RandomString.make(10);

        var puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);

        assertDoesNotThrow(() -> puzzleRepository.save(puzzleEntity));
        assertEquals(1L, puzzleRepository.count());
    }
}
