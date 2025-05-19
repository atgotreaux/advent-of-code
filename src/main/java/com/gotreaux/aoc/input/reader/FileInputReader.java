package com.gotreaux.aoc.input.reader;

import com.google.errorprone.annotations.MustBeClosed;
import java.io.IOException;
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
    public String getInputString() throws IOException {
        return Files.readString(Path.of(inputPath));
    }

    @Override
    @MustBeClosed
    public Stream<String> getInputStream() throws IOException {
        return Files.lines(Path.of(inputPath));
    }

    @Override
    public List<String> getInputList() throws IOException {
        return Files.readAllLines(Path.of(inputPath));
    }
}
