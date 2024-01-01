package com.gotreaux;

import com.gotreaux.input.FileInputProvider;
import com.gotreaux.input.InputProvider;

public abstract class Puzzle {
    private final InputProvider inputProvider;

    public Puzzle() {
        this.inputProvider =
                new FileInputProvider(
                        getClass().getPackage().getName().replaceAll("\\.", "/") + "/input.txt");
    }

    public Puzzle(String fileName) {
        this.inputProvider =
                new FileInputProvider(
                        getClass().getPackage().getName().replaceAll("\\.", "/") + "/" + fileName);
    }

    public Puzzle(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    protected InputProvider getInputProvider() {
        return this.inputProvider;
    }

    public abstract Object getPartOne() throws Exception;

    public abstract Object getPartTwo() throws Exception;

    public void solve() throws Exception {
        System.out.printf("Part 1: %s%n", getPartOne());
        System.out.printf("Part 2: %s%n", getPartTwo());
    }
}
