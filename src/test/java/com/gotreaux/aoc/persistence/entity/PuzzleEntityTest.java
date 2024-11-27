package com.gotreaux.aoc.persistence.entity;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class PuzzleEntityTest {
    @Autowired private List<Puzzle> puzzles;

    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void throwsIfEmpty() {
        PuzzleEntity puzzleEntity = new PuzzleEntity();

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfEmptyYear() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity = new PuzzleEntity(null, puzzle.getDay(), input);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfEmptyDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity = new PuzzleEntity(puzzle.getYear(), null, input);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfEmptyInput() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        PuzzleEntity puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), null);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfInvalidYear() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity =
                new PuzzleEntity(
                        RandomGenerator.getDefault().nextInt(2015), puzzle.getDay(), input);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    void throwsIfInvalidDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity =
                new PuzzleEntity(puzzle.getYear(), generator.nextInt(26, 32), input);

        assertThrows(DataAccessException.class, () -> puzzleRepository.save(puzzleEntity));
    }

    @Test
    @DirtiesContext
    void doesNotInsertIfDuplicate() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);
        PuzzleEntity duplicatePuzzleEntity =
                new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);

        puzzleRepository.save(puzzleEntity);
        puzzleRepository.save(duplicatePuzzleEntity);

        assertEquals(1L, puzzleRepository.count());
    }

    @Test
    @DirtiesContext
    void doesNotThrowIfValid() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);

        assertDoesNotThrow(() -> puzzleRepository.save(puzzleEntity));
        assertEquals(1L, puzzleRepository.count());
    }
}
