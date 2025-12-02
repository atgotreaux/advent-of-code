package com.gotreaux.aoc.puzzles.year2025.day2;

import java.util.function.LongPredicate;
import java.util.stream.IntStream;

class SequenceRepeatsAtLeastTwice implements LongPredicate {

    @Override
    public boolean test(long value) {
        var s = String.valueOf(value);

        return IntStream.rangeClosed(1, s.length() / 2).anyMatch(i -> allPartsEqual(s, i));
    }

    private static boolean allPartsEqual(String s, int partLength) {
        if (s.length() % partLength != 0) {
            return false;
        }

        return IntStream.range(0, s.length() / partLength)
                        .mapToObj(i -> s.substring(i * partLength, (i + 1) * partLength))
                        .distinct()
                        .count()
                == 1;
    }
}
