package com.gotreaux.aoc.puzzles.year2015.day11.functions;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IncreasingCharsPredicate implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return IntStream.range(0, s.length() - 2)
                .anyMatch(
                        i ->
                                s.codePointAt(i) == s.codePointAt(i + 1) - 1
                                        && s.codePointAt(i) == s.codePointAt(i + 2) - 2);
    }
}
