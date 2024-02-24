package com.gotreaux.aoc.puzzles.year2015.day11.functions;

import java.util.function.Predicate;

public class ForbiddenCharsPredicate implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.chars().noneMatch(i -> i == 'i' || i == 'o' || i == 'l');
    }
}
