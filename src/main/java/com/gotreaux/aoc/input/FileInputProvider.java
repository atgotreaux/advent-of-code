package com.gotreaux.aoc.input;

import com.google.errorprone.annotations.MustBeClosed;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileInputProvider implements InputProvider {
    private final String inputPath;

    public FileInputProvider(Class<?> puzzleClass) {
        this.inputPath = puzzleClass.getPackage().getName().replaceAll("\\.", "/") + "/input.txt";
    }

    public FileInputProvider(Class<?> puzzleClass, String fileName) {
        this.inputPath = puzzleClass.getPackage().getName().replaceAll("\\.", "/") + "/" + fileName;
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
        URL resource = getClass().getClassLoader().getResource(this.inputPath);
        if (resource == null) {
            throw new NoSuchFileException(inputPath);
        }

        return Path.of(resource.toURI());
    }
}
