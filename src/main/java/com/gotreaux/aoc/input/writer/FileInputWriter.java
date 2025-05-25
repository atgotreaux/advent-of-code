package com.gotreaux.aoc.input.writer;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputWriter implements InputWriter {
    private final String inputPath;

    public FileInputWriter(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public void write(String input) {
        try {
            Files.writeString(Path.of(inputPath), input);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to write to file: %s".formatted(inputPath), e);
        }
    }
}
