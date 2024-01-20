package com.gotreaux.aoc.input;

import com.google.errorprone.annotations.MustBeClosed;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileInputProvider implements InputProvider {
    private static final Pattern SEPARATOR = Pattern.compile("\\.");
    private final String inputPath;

    public FileInputProvider(Class<?> puzzleClass) {
        this(puzzleClass, "input.txt");
    }

    public FileInputProvider(Class<?> puzzleClass, String fileName) {
        inputPath =
                SEPARATOR.matcher(puzzleClass.getPackage().getName()).replaceAll("/")
                        + "/"
                        + fileName;
    }

    @Override
    public String inputString() throws IOException, URISyntaxException {
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
