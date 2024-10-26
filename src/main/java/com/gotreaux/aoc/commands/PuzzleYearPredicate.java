package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class PuzzleYearPredicate implements BiPredicate<Puzzle, Integer[]> {
    @Override
    public boolean test(Puzzle puzzle, Integer[] years) {
        return years.length == 0 || Arrays.stream(years).anyMatch(year -> year == puzzle.getYear());
    }
}
