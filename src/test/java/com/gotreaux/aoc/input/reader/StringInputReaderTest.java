package com.gotreaux.aoc.input.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class StringInputReaderTest {
    @Test
    void inputAsString() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        InputReader inputReader = new StringInputReader(input);

        assertEquals(input, inputReader.getInputString());
    }

    @Test
    void inputAsStream() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        InputReader inputReader = new StringInputReader(input);

        assertEquals(1L, inputReader.getInputStream().count());
        assertEquals(input, inputReader.getInputStream().toList().getFirst());
    }

    @Test
    void inputAsList() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        InputReader inputReader = new StringInputReader(input);

        assertEquals(1, inputReader.getInputList().size());
        assertEquals(input, inputReader.getInputList().getFirst());
    }
}
