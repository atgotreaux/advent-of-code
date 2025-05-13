package com.gotreaux.aoc.input.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.DatabaseInputReader;
import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.random.RandomGenerator;
import net.bytebuddy.utility.RandomString;
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
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        InputWriter inputWriter =
                new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        var input = RandomString.make(10);

        inputWriter.write(input);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(input, inputReader.getInputString());
    }

    @Test
    void updatesExistingRow() throws Exception {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        InputWriter inputWriter =
                new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());
        inputWriter.write(RandomString.make(10));

        var updatedInput = RandomString.make(10);

        inputWriter.write(updatedInput);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(updatedInput, inputReader.getInputString());
        assertEquals(1L, puzzleRepository.count());
    }
}
