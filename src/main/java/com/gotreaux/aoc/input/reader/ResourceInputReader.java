package com.gotreaux.aoc.input.reader;

import com.google.errorprone.annotations.MustBeClosed;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ResourceInputReader<T extends Puzzle> implements InputReader {
    private static final Pattern SEPARATOR = Pattern.compile("\\.");
    private final String inputPath;

    public ResourceInputReader(Class<T> puzzleClass) {
        this(puzzleClass, "input.txt");
    }

    public ResourceInputReader(Class<T> puzzleClass, String fileName) {
        inputPath =
                SEPARATOR.matcher(puzzleClass.getPackage().getName()).replaceAll("/")
                        + "/"
                        + fileName;
    }

    @Override
    public String getInputString() throws IOException, URISyntaxException {
        return Files.readString(loadResource());
    }

    @Override
    @MustBeClosed
    public Stream<String> getInputStream() throws IOException, URISyntaxException {
        return Files.lines(loadResource());
    }

    @Override
    public List<String> getInputList() throws IOException, URISyntaxException {
        return Files.readAllLines(loadResource());
    }

    private Path loadResource() throws NoSuchFileException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(inputPath);
        if (resource == null) {
            throw new NoSuchFileException(inputPath);
        }

        return Path.of(resource.toURI());
    }
}
