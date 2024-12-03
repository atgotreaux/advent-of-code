package com.gotreaux.aoc.input.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

class StringInputReaderTest {
    @Test
    void inputAsString() throws Exception {
        String input = RandomString.make(10);

        InputReader inputReader = new StringInputReader(input);

        assertEquals(input, inputReader.getInputString());
    }

    @Test
    void inputAsStream() throws Exception {
        String input = RandomString.make(10);

        InputReader inputReader = new StringInputReader(input);

        assertEquals(1L, inputReader.getInputStream().count());
        assertEquals(input, inputReader.getInputStream().toList().getFirst());
    }

    @Test
    void inputAsList() throws Exception {
        String input = RandomString.make(10);

        InputReader inputReader = new StringInputReader(input);

        assertEquals(1, inputReader.getInputList().size());
        assertEquals(input, inputReader.getInputList().getFirst());
    }
}
