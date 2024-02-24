package com.gotreaux.aoc.puzzles.year2015.day11.functions;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class TwoPairsPredicate implements Predicate<String> {
    @Override
    public boolean test(String s) {
        IntPredicate overlappingPair =
                i -> s.charAt(i) == s.charAt(i + 1) && (i == 0 || s.charAt(i) != s.charAt(i - 1));
        return IntStream.range(0, s.length() - 1).filter(overlappingPair).count() >= 2L;
    }
}
