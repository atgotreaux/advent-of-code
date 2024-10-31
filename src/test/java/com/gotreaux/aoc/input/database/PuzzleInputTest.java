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
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey();
        puzzleInputKey.setPuzzleDay(puzzle.getDay());

        PuzzleInput puzzleInput = new PuzzleInput();
        puzzleInput.setId(puzzleInputKey);

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);
        puzzleInput.setInputData(inputData);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void throwsIfEmptyDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey();
        puzzleInputKey.setPuzzleYear(puzzle.getYear());

        PuzzleInput puzzleInput = new PuzzleInput();
        puzzleInput.setId(puzzleInputKey);

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);
        puzzleInput.setInputData(inputData);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void throwsIfEmptyInputData() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey(puzzle.getYear(), puzzle.getDay());

        PuzzleInput puzzleInput = new PuzzleInput();
        puzzleInput.setId(puzzleInputKey);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void throwsIfInvalidYear() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey();
        puzzleInputKey.setPuzzleYear(RandomGenerator.getDefault().nextInt(2015));
        puzzleInputKey.setPuzzleDay(puzzle.getDay());

        PuzzleInput puzzleInput = new PuzzleInput();
        puzzleInput.setId(puzzleInputKey);

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);
        puzzleInput.setInputData(inputData);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void throwsIfInvalidDay() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey();
        puzzleInputKey.setPuzzleYear(puzzle.getYear());
        puzzleInputKey.setPuzzleDay(generator.nextInt(26, 32));

        PuzzleInput puzzleInput = new PuzzleInput();
        puzzleInput.setId(puzzleInputKey);

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);
        puzzleInput.setInputData(inputData);

        assertThrows(DataAccessException.class, () -> puzzleInputRepository.save(puzzleInput));
    }

    @Test
    void doesNotThrowIfValid() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey(puzzle.getYear(), puzzle.getDay());

        PuzzleInput puzzleInput = new PuzzleInput();
        puzzleInput.setId(puzzleInputKey);

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);
        puzzleInput.setInputData(inputData);

        assertDoesNotThrow(() -> puzzleInputRepository.save(puzzleInput));
        assertEquals(1L, puzzleInputRepository.count());
    }
}
