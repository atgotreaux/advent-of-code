package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import org.springframework.lang.Nullable;

class PuzzlePredicate<T> implements Predicate<Puzzle> {

    private final Function<Puzzle, T> callback;
    private final @Nullable T[] values;

    @SafeVarargs
    PuzzlePredicate(Function<Puzzle, T> callback, T... values) {
        this.callback = callback;
        this.values = Arrays.copyOf(values, values.length);
    }

    @Override
    public boolean test(Puzzle puzzle) {
        T puzzleValue = callback.apply(puzzle);

        return values == null || values.length == 0 || Arrays.asList(values).contains(puzzleValue);
    }
}
