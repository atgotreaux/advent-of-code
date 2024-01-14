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
        return annotation.year();
    }

    public int day() {
        return annotation.day();
    }

    public String title() {
        return annotation.title();
    }

    public PuzzleOutput<?, ?> getOutput() throws Exception {
        return puzzle.solve();
    }
}
