package com.gotreaux.aoc.input.reader;

import com.google.errorprone.annotations.MustBeClosed;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileInputReader implements InputReader {
    private final String inputPath;

    public FileInputReader(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public String getInputString() {
        return readFile(Files::readString);
    }

    @Override
    @MustBeClosed
    public Stream<String> getInputStream() {
        return readFile(Files::lines);
    }

    @Override
    public List<String> getInputList() {
        return readFile(Files::readAllLines);
    }

    private <T> T readFile(PathReader<T> reader) {
        try {
            return reader.read(Path.of(inputPath));
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read file: %s".formatted(inputPath), e);
        }
    }
}
