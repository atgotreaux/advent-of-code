package com.gotreaux.aoc.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.input.database.PuzzleInput;
import com.gotreaux.aoc.input.database.PuzzleInputKey;
import com.gotreaux.aoc.input.database.PuzzleInputRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class DatabaseInputProviderTest {

    @Autowired private List<Puzzle> puzzles;

    @Autowired private PuzzleInputRepository puzzleInputRepository;

    @Test
    void throwsIfNotFound() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));
        PuzzleInputKey puzzleInputKey = new PuzzleInputKey(puzzle.getYear(), puzzle.getDay());

        InputProvider inputProvider =
                new DatabaseInputProvider(puzzleInputRepository, puzzleInputKey);

        assertThrows(NoSuchElementException.class, inputProvider::getInputString);
    }

    @Test
    void inputAsString() throws Exception {
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

        InputProvider inputProvider =
                new DatabaseInputProvider(puzzleInputRepository, puzzleInputKey);

        assertEquals(puzzleInput.getInputData(), inputProvider.getInputString());
    }

    @Test
    void inputAsStream() throws Exception {
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

        InputProvider inputProvider =
                new DatabaseInputProvider(puzzleInputRepository, puzzleInputKey);

        assertEquals(1L, inputProvider.getInputStream().count());
        assertEquals(
                puzzleInput.getInputData(), inputProvider.getInputStream().toList().getFirst());
    }

    @Test
    void puzzleInputAsList() throws Exception {
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

        InputProvider inputProvider =
                new DatabaseInputProvider(puzzleInputRepository, puzzleInputKey);

        assertEquals(1, inputProvider.getInputList().size());
        assertEquals(puzzleInput.getInputData(), inputProvider.getInputList().getFirst());
    }
}
