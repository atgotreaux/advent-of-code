package com.gotreaux.aoc.input.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class FileInputWriter implements InputWriter {
    private final String inputPath;

    public FileInputWriter(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public void write(String input) throws IOException, InvalidPathException {
        Files.writeString(Path.of(inputPath), input);
    }
}
