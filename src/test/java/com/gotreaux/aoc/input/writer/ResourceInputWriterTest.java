package com.gotreaux.aoc.input.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.puzzles.year2015.day1.ApartmentFloorPuzzle;
import java.nio.charset.StandardCharsets;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class ResourceInputWriterTest {
    @Test
    void writesToResourceFile() throws Exception {
        RandomGenerator generator = RandomGenerator.getDefault();

        byte[] bytes = new byte[generator.nextInt(0, 10)];
        generator.nextBytes(bytes);
        String input = new String(bytes, StandardCharsets.UTF_8);

        InputWriter inputWriter = new ResourceInputWriter<>(ApartmentFloorPuzzle.class);
        inputWriter.write(input);

        InputReader inputReader = new ResourceInputReader<>(ApartmentFloorPuzzle.class);

        assertEquals(input, inputReader.getInputString());
    }
}
