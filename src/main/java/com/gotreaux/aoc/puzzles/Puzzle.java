package com.gotreaux.aoc.puzzles;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;

public abstract class Puzzle {
    private final InputProvider inputProvider;

    public Puzzle(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    protected InputProvider getInputProvider() {
        return this.inputProvider;
    }

    public abstract PuzzleOutput<?, ?> solve() throws Exception;
}
