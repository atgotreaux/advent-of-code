package com.gotreaux.aoc.input;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class StringInputProviderTest {
    @Test
    void inputAsString() {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        StringInputProvider inputProvider = new StringInputProvider(input);

        assertEquals(input, inputProvider.getInputString());
    }

    @Test
    void inputAsStream() {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        StringInputProvider inputProvider = new StringInputProvider(input);

        assertEquals(1L, inputProvider.getInputStream().count());
        assertEquals(input, inputProvider.getInputStream().toList().getFirst());
    }

    @Test
    void inputAsList() {
        RandomGenerator generator = RandomGenerator.getDefault();
        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        StringInputProvider inputProvider = new StringInputProvider(input);

        assertEquals(1, inputProvider.getInputList().size());
        assertEquals(input, inputProvider.getInputList().getFirst());
    }
}
