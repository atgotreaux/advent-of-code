package com.gotreaux.aoc.puzzles;

import com.gotreaux.aoc.input.InputProvider;

public abstract class Puzzle {
    private final InputProvider inputProvider;

    public Puzzle(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    protected InputProvider getInputProvider() {
        return this.inputProvider;
    }

    public abstract Object getPartOne() throws Exception;

    public abstract Object getPartTwo() throws Exception;
}
