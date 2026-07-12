package com.gotreaux.aoc.input.writer;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.service.PuzzleService;
import java.io.IOException;
import java.nio.file.Files;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InputWriterFactoryTest {
    @Autowired private PuzzleService puzzleService;
    @Autowired private InputWriterFactory factory;

    @Test
    void createsDatabaseWriter() {
        var puzzle = puzzleService.getRandomPuzzle();

        assertInstanceOf(
                DatabaseInputWriter.class,
                factory.create(puzzle, InputWriterFactory.DATABASE_WRITER));
    }

    @Test
    void createsResourceWriter() {
        var puzzle = puzzleService.getRandomPuzzle();

        assertInstanceOf(
                ResourceInputWriter.class,
                factory.create(puzzle, InputWriterFactory.RESOURCE_WRITER));
    }

    @Test
    void createsFileWriter() throws IOException {
        var puzzle = puzzleService.getRandomPuzzle();

        var path = Files.createTempFile("input", ".txt");

        assertInstanceOf(
                FileInputWriter.class, factory.create(puzzle, path.toAbsolutePath().toString()));
    }

    @Test
    void failsToCreateFileWriterIfFileDoesNotExist() throws IOException {
        var puzzle = puzzleService.getRandomPuzzle();

        var path = Files.createTempFile("input", ".txt");

        var target = path.toAbsolutePath().toString().replace("input", "input2");

        assertThrows(IllegalStateException.class, () -> factory.create(puzzle, target));
    }

    @Test
    void failsToCreateWriterIfString() {
        var puzzle = puzzleService.getRandomPuzzle();

        var target = RandomString.make(10);

        assertThrows(IllegalStateException.class, () -> factory.create(puzzle, target));
    }
}
