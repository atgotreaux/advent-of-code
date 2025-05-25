package com.gotreaux.aoc.input.reader;

import com.google.errorprone.annotations.MustBeClosed;
import com.gotreaux.aoc.input.ResourceLoader;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

public class ResourceInputReader<T extends Puzzle> implements InputReader {
    private final ResourceLoader resourceLoader;

    public ResourceInputReader(Class<T> puzzleClass) {
        this(puzzleClass, "input.txt");
    }

    public ResourceInputReader(Class<T> puzzleClass, String fileName) {
        resourceLoader =
                new ResourceLoader(puzzleClass.getPackageName().replace(".", "/") + "/" + fileName);
    }

    @Override
    public String getInputString() {
        return readResource(Files::readString);
    }

    @Override
    @MustBeClosed
    public Stream<String> getInputStream() {
        return readResource(Files::lines);
    }

    @Override
    public List<String> getInputList() {
        return readResource(Files::readAllLines);
    }

    private <P> P readResource(PathReader<P> reader) {
        try {
            return reader.read(resourceLoader.load());
        } catch (IOException e) {
            throw new UncheckedIOException(
                    "Failed to read resource: %s".formatted(resourceLoader.inputPath()), e);
        }
    }
}
