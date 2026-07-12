package com.gotreaux.aoc.input.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.input.writer.DatabaseInputWriter;
import com.gotreaux.aoc.input.writer.InputWriter;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.service.PuzzleService;
import java.util.NoSuchElementException;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class DatabaseInputReaderTest {

    @Autowired private PuzzleService puzzleService;

    @Autowired private PuzzleRepository puzzleRepository;

    @Test
    void throwsIfNotFound() {
        var puzzle = puzzleService.getRandomPuzzle();

        InputReader inputReader =
                new DatabaseInputReader(puzzleRepository, puzzle.getYear(), puzzle.getDay());

        assertThrows(NoSuchElementException.class, inputReader::getInputString);
    }

    @Test
    @DirtiesContext
    void inputAsString() {
        var puzzle = puzzleService.getRandomPuzzle();

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
        var puzzle = puzzleService.getRandomPuzzle();

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
        var puzzle = puzzleService.getRandomPuzzle();

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
