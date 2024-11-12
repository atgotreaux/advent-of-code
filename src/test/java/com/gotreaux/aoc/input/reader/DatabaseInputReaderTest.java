package com.gotreaux.aoc.input.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.persistence.entity.PuzzleEntity;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
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
class DatabaseInputReaderTest {

    @Autowired private List<Puzzle> puzzles;

    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void throwsIfNotFound() {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertThrows(NoSuchElementException.class, inputReader::getInputString);
    }

    @Test
    void inputAsString() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);

        puzzleRepository.save(puzzleEntity);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(puzzleEntity.getInput(), inputReader.getInputString());
    }

    @Test
    void inputAsStream() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);

        puzzleRepository.save(puzzleEntity);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(1L, inputReader.getInputStream().count());
        assertEquals(puzzleEntity.getInput(), inputReader.getInputStream().toList().getFirst());
    }

    @Test
    void puzzleInputAsList() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);

        puzzleRepository.save(puzzleEntity);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(1, inputReader.getInputList().size());
        assertEquals(puzzleEntity.getInput(), inputReader.getInputList().getFirst());
    }
}
