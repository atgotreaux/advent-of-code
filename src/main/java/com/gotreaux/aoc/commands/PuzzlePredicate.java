package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;

class PuzzlePredicate implements BiPredicate<Puzzle, Integer[]> {

    private final Function<Puzzle, Integer> callback;

    PuzzlePredicate(Function<Puzzle, Integer> callback) {
        this.callback = callback;
    }

    @Override
    public boolean test(Puzzle puzzle, Integer[] values) {
        int puzzleValue = callback.apply(puzzle);

        return values.length == 0 || Arrays.stream(values).anyMatch(i -> puzzleValue == i);
    }
}
