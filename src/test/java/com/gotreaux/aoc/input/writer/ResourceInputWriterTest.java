package com.gotreaux.aoc.input.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.puzzles.year2015.day1.ApartmentFloorPuzzle;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

class ResourceInputWriterTest {
    @Test
    void writesToResourceFile() {
        var input = RandomString.make(10);

        InputWriter inputWriter = new ResourceInputWriter<>(ApartmentFloorPuzzle.class);
        inputWriter.write(input);

        InputReader inputReader = new ResourceInputReader<>(ApartmentFloorPuzzle.class);

        assertEquals(input, inputReader.getInputString());
    }
}
