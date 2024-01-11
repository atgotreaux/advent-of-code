package com.gotreaux.aoc.dto;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;

public class PuzzleDto {
    private final ShellPuzzle annotation;
    private final Puzzle puzzle;

    public PuzzleDto(ShellPuzzle annotation, Puzzle puzzle) {
        this.annotation = annotation;
        this.puzzle = puzzle;
    }

    public int year() {
        return this.annotation.year();
    }

    public int day() {
        return this.annotation.day();
    }

    public String title() {
        return this.annotation.title();
    }

    public PuzzleOutput<?, ?> getOutput() throws Exception {
        return this.puzzle.solve();
    }
}
