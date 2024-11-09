package com.gotreaux.aoc.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class FileInputProviderTest {
    @Test
    void throwsIfFileNotFound() {
        InputProvider inputProvider = new FileInputProvider("input.txt");

        assertThrows(NoSuchFileException.class, inputProvider::getInputString);
    }

    @Test
    void inputAsString() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        CharSequence input = new String(bytes, StandardCharsets.UTF_8);

        Path path = Files.createTempFile("input", ".txt");
        Files.writeString(path, input);

        InputProvider inputProvider = new FileInputProvider(path.toAbsolutePath().toString());

        assertEquals(input, inputProvider.getInputString());
    }

    @Test
    void inputAsStream() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        CharSequence input = new String(bytes, StandardCharsets.UTF_8);

        Path path = Files.createTempFile("input", ".txt");
        Files.writeString(path, input);

        InputProvider inputProvider = new FileInputProvider(path.toAbsolutePath().toString());

        assertEquals(1, inputProvider.getInputStream().count());
        assertEquals(input, inputProvider.getInputStream().toList().getFirst());
    }

    @Test
    void inputAsList() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        CharSequence input = new String(bytes, StandardCharsets.UTF_8);

        Path path = Files.createTempFile("input", ".txt");
        Files.writeString(path, input);

        InputProvider inputProvider = new FileInputProvider(path.toAbsolutePath().toString());

        assertEquals(1, inputProvider.getInputList().size());
        assertEquals(input, inputProvider.getInputList().getFirst());
    }
}
