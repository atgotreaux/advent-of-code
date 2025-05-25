package com.gotreaux.aoc.input.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.input.writer.FileInputWriter;
import com.gotreaux.aoc.input.writer.InputWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

class FileInputReaderTest {
    @Test
    void throwsIfFileNotFound() {
        InputReader inputReader = new FileInputReader("input.txt");

        assertThrows(UncheckedIOException.class, inputReader::getInputString);
    }

    @Test
    void inputAsString() throws IOException {
        var input = RandomString.make(10);

        var path = Files.createTempFile("input", ".txt");

        InputWriter inputWriter = new FileInputWriter(path.toAbsolutePath().toString());
        inputWriter.write(input);

        InputReader inputReader = new FileInputReader(path.toAbsolutePath().toString());

        assertEquals(input, inputReader.getInputString());
    }

    @Test
    void inputAsStream() throws IOException {
        var input = RandomString.make(10);

        var path = Files.createTempFile("input", ".txt");

        InputWriter inputWriter = new FileInputWriter(path.toAbsolutePath().toString());
        inputWriter.write(input);

        InputReader inputReader = new FileInputReader(path.toAbsolutePath().toString());

        assertEquals(1, inputReader.getInputStream().count());
        assertEquals(input, inputReader.getInputStream().toList().getFirst());
    }

    @Test
    void inputAsList() throws IOException {
        var input = RandomString.make(10);

        var path = Files.createTempFile("input", ".txt");

        InputWriter inputWriter = new FileInputWriter(path.toAbsolutePath().toString());
        inputWriter.write(input);

        InputReader inputReader = new FileInputReader(path.toAbsolutePath().toString());

        assertEquals(1, inputReader.getInputList().size());
        assertEquals(input, inputReader.getInputList().getFirst());
    }
}
