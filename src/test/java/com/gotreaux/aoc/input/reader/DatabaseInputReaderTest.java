package com.gotreaux.aoc.input.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.input.writer.DatabaseInputWriter;
import com.gotreaux.aoc.input.writer.InputWriter;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class DatabaseInputReaderTest {

    @Autowired private List<Puzzle> puzzles;

    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void throwsIfNotFound() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertThrows(NoSuchElementException.class, inputReader::getInputString);
    }

    @Test
    @DirtiesContext
    void inputAsString() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var input = RandomString.make(10);

        InputWriter inputWriter =
                new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());
        inputWriter.write(input);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(input, inputReader.getInputString());
    }

    @Test
    @DirtiesContext
    void inputAsStream() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var input = RandomString.make(10);

        InputWriter inputWriter =
                new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());
        inputWriter.write(input);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(1L, inputReader.getInputStream().count());
        assertEquals(input, inputReader.getInputStream().toList().getFirst());
    }

    @Test
    @DirtiesContext
    void puzzleInputAsList() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var input = RandomString.make(10);

        InputWriter inputWriter =
                new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());
        inputWriter.write(input);

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertEquals(1, inputReader.getInputList().size());
        assertEquals(input, inputReader.getInputList().getFirst());
    }
}
