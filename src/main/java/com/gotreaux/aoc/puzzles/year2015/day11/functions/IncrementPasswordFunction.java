package com.gotreaux.aoc.puzzles.year2015.day11.functions;

import java.util.function.Function;

public class IncrementPasswordFunction implements Function<String, String> {
    @Override
    public String apply(String s) {
        var result = new StringBuilder(s.length());
        var incremented = false;

        for (var i = s.length() - 1; i >= 0; i--) {
            if (incremented) {
                result.append(s.charAt(i));
            } else if (s.charAt(i) == 'z') {
                result.append('a');
            } else {
                result.appendCodePoint(s.codePointAt(i) + 1);
                incremented = true;
            }
        }

        if (!incremented) {
            result.append('a');
        }

        return result.reverse().toString();
    }
}
