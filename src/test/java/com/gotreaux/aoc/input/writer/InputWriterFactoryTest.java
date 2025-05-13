package com.gotreaux.aoc.input.writer;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.random.RandomGenerator;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InputWriterFactoryTest {
    @Autowired private List<Puzzle> puzzles;
    @Autowired private InputWriterFactory factory;

    @Test
    void createsDatabaseWriter() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        assertInstanceOf(
                DatabaseInputWriter.class,
                factory.create(puzzle, InputWriterFactory.DATABASE_WRITER));
    }

    @Test
    void createsResourceWriter() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        assertInstanceOf(
                ResourceInputWriter.class,
                factory.create(puzzle, InputWriterFactory.RESOURCE_WRITER));
    }

    @Test
    void createsFileWriter() throws IOException {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var path = Files.createTempFile("input", ".txt");

        assertInstanceOf(
                FileInputWriter.class, factory.create(puzzle, path.toAbsolutePath().toString()));
    }

    @Test
    void failsToCreateFileWriterIfFileDoesNotExist() throws IOException {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var path = Files.createTempFile("input", ".txt");

        var target = path.toAbsolutePath().toString().replace("input", "input2");

        assertThrows(IllegalStateException.class, () -> factory.create(puzzle, target));
    }

    @Test
    void failsToCreateWriterIfString() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var target = RandomString.make(10);

        assertThrows(IllegalStateException.class, () -> factory.create(puzzle, target));
    }
}
