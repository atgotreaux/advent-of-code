package com.gotreaux.aoc.input.database;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class PuzzleInputTest {
    @Autowired private List<Puzzle> puzzles;

    @Autowired private PuzzleInputRepository puzzleInputRepository;

    @Test
    void throwsIfEmpty() {
        PuzzleInput puzzleInput = new PuzzleInput();

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void throwsIfEmptyYear() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);

        PuzzleInput puzzleInput = new PuzzleInput(null, puzzle.getDay(), inputData);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void throwsIfEmptyDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);

        PuzzleInput puzzleInput = new PuzzleInput(puzzle.getYear(), null, inputData);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void throwsIfEmptyInputData() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        PuzzleInput puzzleInput = new PuzzleInput(puzzle.getYear(), puzzle.getDay(), null);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void throwsIfInvalidYear() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);

        PuzzleInput puzzleInput =
                new PuzzleInput(
                        RandomGenerator.getDefault().nextInt(2015), puzzle.getDay(), inputData);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void throwsIfInvalidDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);

        PuzzleInput puzzleInput =
                new PuzzleInput(puzzle.getYear(), generator.nextInt(26, 32), inputData);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void doesNotInsertIfDuplicate() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);

        PuzzleInput puzzleInput = new PuzzleInput(puzzle.getYear(), puzzle.getDay(), inputData);
        PuzzleInput duplicatePuzzleInput =
                new PuzzleInput(puzzle.getYear(), puzzle.getDay(), inputData);

        puzzleInputRepository.save(puzzleInput);
        puzzleInputRepository.save(duplicatePuzzleInput);

        assertEquals(1L, puzzleInputRepository.count());
    }

    @Test
    void doesNotThrowIfValid() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);

        PuzzleInput puzzleInput = new PuzzleInput(puzzle.getYear(), puzzle.getDay(), inputData);

        assertDoesNotThrow(() -> puzzleInputRepository.save(puzzleInput));
        assertEquals(1L, puzzleInputRepository.count());
    }
}
