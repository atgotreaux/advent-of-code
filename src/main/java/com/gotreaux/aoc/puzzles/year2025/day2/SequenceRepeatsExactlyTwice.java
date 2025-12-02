package com.gotreaux.aoc.puzzles.year2025.day2;

import java.util.function.LongPredicate;

class SequenceRepeatsExactlyTwice implements LongPredicate {

    @Override
    public boolean test(long value) {
        var s = String.valueOf(value);
        var length = s.length();

        if (length % 2 != 0) {
            return false;
        }

        var first = s.substring(0, length / 2);
        var second = s.substring(length / 2);

        return first.equals(second);
    }
}
