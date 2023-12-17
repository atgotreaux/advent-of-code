package com.gotreaux;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public abstract class Puzzle {
    private final String inputPath;

    public Puzzle() {
        this.inputPath = getClass().getPackage().getName().replaceAll("\\.", "/") + "/input.txt";
    }

    public Puzzle(String fileName) {
        this.inputPath = getClass().getPackage().getName().replaceAll("\\.", "/") + "/" + fileName;
    }

    protected Path getInput() throws NoSuchFileException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(this.inputPath);
        if (resource == null) {
            throw new NoSuchFileException(inputPath);
        }

        return Path.of(resource.toURI());
    }

    public abstract void prepare() throws Exception;

    public abstract Object getPartOne();

    public abstract Object getPartTwo();

    public void solve() throws Exception {
        prepare();

        System.out.printf("Part 1: %s%n", getPartOne());
        System.out.printf("Part 2: %s%n", getPartTwo());
    }
}
