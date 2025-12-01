package com.gotreaux.aoc.puzzles;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public abstract class Puzzle {

    @Min(2015)
    @Max(2025)
    private final int year;

    @Min(1)
    @Max(25)
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

    public abstract PuzzleOutput<?, ?> solve(InputReader inputReader);
}
