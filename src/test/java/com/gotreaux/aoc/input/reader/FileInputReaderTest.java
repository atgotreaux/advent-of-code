package com.gotreaux.aoc.input.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class FileInputReaderTest {
    @Test
    void throwsIfFileNotFound() {
        InputReader inputReader = new FileInputReader("input.txt");

        assertThrows(NoSuchFileException.class, inputReader::getInputString);
    }

    @Test
    void inputAsString() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        CharSequence input = new String(bytes, StandardCharsets.UTF_8);

        Path path = Files.createTempFile("input", ".txt");
        Files.writeString(path, input);

        InputReader inputReader = new FileInputReader(path.toAbsolutePath().toString());

        assertEquals(input, inputReader.getInputString());
    }

    @Test
    void inputAsStream() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        CharSequence input = new String(bytes, StandardCharsets.UTF_8);

        Path path = Files.createTempFile("input", ".txt");
        Files.writeString(path, input);

        InputReader inputReader = new FileInputReader(path.toAbsolutePath().toString());

        assertEquals(1, inputReader.getInputStream().count());
        assertEquals(input, inputReader.getInputStream().toList().getFirst());
    }

    @Test
    void inputAsList() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        CharSequence input = new String(bytes, StandardCharsets.UTF_8);

        Path path = Files.createTempFile("input", ".txt");
        Files.writeString(path, input);

        InputReader inputReader = new FileInputReader(path.toAbsolutePath().toString());

        assertEquals(1, inputReader.getInputList().size());
        assertEquals(input, inputReader.getInputList().getFirst());
    }
}
