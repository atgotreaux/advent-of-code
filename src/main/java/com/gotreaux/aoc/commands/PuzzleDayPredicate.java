package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class PuzzleDayPredicate implements BiPredicate<Puzzle, Integer[]> {
    @Override
    public boolean test(Puzzle puzzle, Integer[] days) {
        return days.length == 0 || Arrays.stream(days).anyMatch(day -> day == puzzle.getDay());
    }
}
