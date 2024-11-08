package com.gotreaux.aoc.input;

import com.google.errorprone.annotations.MustBeClosed;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileInputProvider implements InputProvider {
    private final String inputPath;

    public FileInputProvider(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public String getInputString() throws IOException, URISyntaxException {
        return Files.readString(Path.of(inputPath));
    }

    @Override
    @MustBeClosed
    public Stream<String> getInputStream() throws IOException, URISyntaxException {
        return Files.lines(Path.of(inputPath));
    }

    @Override
    public List<String> getInputList() throws IOException, URISyntaxException {
        return Files.readAllLines(Path.of(inputPath));
    }
}
