package com.gotreaux.aoc.input.writer;

import com.gotreaux.aoc.input.ResourceLoader;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ResourceInputWriter<T extends Puzzle> implements InputWriter {
    private final ResourceLoader resourceLoader;

    public ResourceInputWriter(Class<T> puzzleClass) {
        resourceLoader =
                new ResourceLoader(puzzleClass.getPackageName().replace(".", "/") + "/input.txt");
    }

    @Override
    public void write(String input) {
        try {
            Files.writeString(resourceLoader.load(), input, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(
                    "Failed to write resource: %s".formatted(resourceLoader.inputPath()), e);
        }
    }
}
