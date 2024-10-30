package com.gotreaux.aoc.input.database;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class PuzzleInputRepositoryTest {
    @Autowired private List<Puzzle> puzzles;

    @Autowired private PuzzleInputRepository puzzleInputRepository;

    @Test
    void emptyIfNotFound() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey(puzzle.getYear(), puzzle.getDay());

        assertTrue(puzzleInputRepository.findById(puzzleInputKey).isEmpty());
    }

    @Test
    void testPresentIfFound() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey(puzzle.getYear(), puzzle.getDay());

        PuzzleInput puzzleInput = new PuzzleInput();
        puzzleInput.setId(puzzleInputKey);

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String inputData = new String(bytes, StandardCharsets.UTF_8);
        puzzleInput.setInputData(inputData);

        puzzleInputRepository.save(puzzleInput);

        assertTrue(puzzleInputRepository.findById(puzzleInputKey).isPresent());
    }
}
