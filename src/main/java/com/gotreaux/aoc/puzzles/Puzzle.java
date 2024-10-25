package com.gotreaux.aoc.puzzles;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;

public abstract class Puzzle {

    private final int year;
    private final int day;

    protected Puzzle(int year, int day) {
        this.year = year;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public abstract PuzzleOutput<?, ?> solve(InputProvider inputProvider) throws Exception;
}
