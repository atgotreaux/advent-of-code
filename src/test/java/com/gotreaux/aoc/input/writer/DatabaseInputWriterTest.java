package com.gotreaux.aoc.input.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.DatabaseInputReader;
import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.persistence.entity.PuzzleEntity;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
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
class DatabaseInputWriterTest {

    @Autowired private List<Puzzle> puzzles;

    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void writesNewRowToTable() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        InputWriter inputWriter =
                new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        inputWriter.write(input);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(input, inputReader.getInputString());
    }

    @Test
    void updatesExistingRow() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        Puzzle puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        PuzzleEntity puzzleEntity = new PuzzleEntity(puzzle.getYear(), puzzle.getDay(), input);
        puzzleRepository.save(puzzleEntity);

        InputWriter inputWriter =
                new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        byte[] updatedBytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(updatedBytes);
        String updatedInput = new String(updatedBytes, StandardCharsets.UTF_8);

        inputWriter.write(updatedInput);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(updatedInput, inputReader.getInputString());
        assertEquals(1L, puzzleRepository.count());
    }
}
