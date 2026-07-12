package com.gotreaux.aoc.input.reader;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.gotreaux.aoc.service.PuzzleService;
import java.io.IOException;
import java.nio.file.Files;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InputReaderFactoryTest {
    @Autowired private PuzzleService puzzleService;
    @Autowired private InputReaderFactory factory;

    @Test
    void createsDatabaseReader() {
        var puzzle = puzzleService.getRandomPuzzle();

        assertInstanceOf(
                DatabaseInputReader.class,
                factory.create(puzzle, InputReaderFactory.DATABASE_READER));
    }

    @Test
    void createsResourceReader() {
        var puzzle = puzzleService.getRandomPuzzle();

        assertInstanceOf(
                ResourceInputReader.class,
                factory.create(puzzle, InputReaderFactory.RESOURCE_READER));
    }

    @Test
    void createsFileReader() throws IOException {
        var puzzle = puzzleService.getRandomPuzzle();

        var path = Files.createTempFile("input", ".txt");

        assertInstanceOf(
                FileInputReader.class, factory.create(puzzle, path.toAbsolutePath().toString()));
    }

    @Test
    void createsStringReaderIfFileDoesNotExist() throws IOException {
        var puzzle = puzzleService.getRandomPuzzle();

        var path = Files.createTempFile("input", ".txt");

        var target = path.toAbsolutePath().toString().replace("input", "input2");

        assertInstanceOf(StringInputReader.class, factory.create(puzzle, target));
    }

    @Test
    void createsStringReader() {
        var puzzle = puzzleService.getRandomPuzzle();

        var target = RandomString.make(10);

        assertInstanceOf(StringInputReader.class, factory.create(puzzle, target));
    }
}
