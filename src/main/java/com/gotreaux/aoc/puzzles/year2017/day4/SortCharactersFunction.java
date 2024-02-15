package com.gotreaux.aoc.puzzles.year2017.day4;

import java.util.function.Function;

public class SortCharactersFunction implements Function<String, String> {
    @Override
    public String apply(String s) {
        return s.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
