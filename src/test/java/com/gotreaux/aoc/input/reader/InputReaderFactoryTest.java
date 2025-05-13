package com.gotreaux.aoc.input.reader;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

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
class InputReaderFactoryTest {
    @Autowired private List<Puzzle> puzzles;
    @Autowired private InputReaderFactory factory;

    @Test
    void createsDatabaseReader() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        assertInstanceOf(
                DatabaseInputReader.class,
                factory.create(puzzle, InputReaderFactory.DATABASE_READER));
    }

    @Test
    void createsResourceReader() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        assertInstanceOf(
                ResourceInputReader.class,
                factory.create(puzzle, InputReaderFactory.RESOURCE_READER));
    }

    @Test
    void createsFileReader() throws IOException {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var path = Files.createTempFile("input", ".txt");

        assertInstanceOf(
                FileInputReader.class, factory.create(puzzle, path.toAbsolutePath().toString()));
    }

    @Test
    void createsStringReaderIfFileDoesNotExist() throws IOException {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var path = Files.createTempFile("input", ".txt");

        var target = path.toAbsolutePath().toString().replace("input", "input2");

        assertInstanceOf(StringInputReader.class, factory.create(puzzle, target));
    }

    @Test
    void createsStringReader() {
        var generator = RandomGenerator.getDefault();
        var puzzle = puzzles.get(generator.nextInt(puzzles.size()));

        var target = RandomString.make(10);

        assertInstanceOf(StringInputReader.class, factory.create(puzzle, target));
    }
}
