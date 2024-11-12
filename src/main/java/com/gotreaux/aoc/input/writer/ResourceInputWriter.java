package com.gotreaux.aoc.input.writer;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class ResourceInputWriter<T extends Puzzle> implements InputWriter {
    private static final Pattern SEPARATOR = Pattern.compile("\\.");
    private final String inputPath;

    public ResourceInputWriter(Class<T> puzzleClass) {
        inputPath =
                SEPARATOR.matcher(puzzleClass.getPackage().getName()).replaceAll("/")
                        + "/input.txt";
    }

    @Override
    public void write(String input) throws IOException, URISyntaxException {
        Files.writeString(loadResource(), input, StandardCharsets.UTF_8);
    }

    private Path loadResource() throws NoSuchFileException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(inputPath);
        if (resource == null) {
            throw new NoSuchFileException(inputPath);
        }

        return Path.of(resource.toURI());
    }
}
