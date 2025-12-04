package com.gotreaux.aoc.puzzles;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public abstract class Puzzle<A, B> {

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

    //TODO make abstract after all puzzles are refactored
    public A solvePartOne(InputReader inputReader) {
        return (A) new Object();
    }

    //TODO make abstract after all puzzles are refactored
    public B solvePartTwo(InputReader inputReader) {
        return (B) new Object();
    }

    // TODO remove after all puzzles are refactored
    public PuzzleOutput<?, ?> solve(InputReader inputReader) {
        return new PuzzleOutput<>(0, 0);
    }
}
