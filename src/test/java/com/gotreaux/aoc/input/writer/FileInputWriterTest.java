package com.gotreaux.aoc.input.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.FileInputReader;
import com.gotreaux.aoc.input.reader.InputReader;
import java.nio.file.Files;
import java.nio.file.Path;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

class FileInputWriterTest {
    @Test
    void writesToFile() throws Exception {
        String input = RandomString.make(10);

        Path path = Files.createTempFile("input", ".txt");

        InputWriter inputWriter = new FileInputWriter(path.toAbsolutePath().toString());
        inputWriter.write(input);

        InputReader inputReader = new FileInputReader(path.toAbsolutePath().toString());

        assertEquals(input, inputReader.getInputString());
    }
}
