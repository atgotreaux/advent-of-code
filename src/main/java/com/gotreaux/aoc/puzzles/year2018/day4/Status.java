package com.gotreaux.aoc.puzzles.year2018.day4;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

enum Status {
    WAKES_UP(GuardRecord.WAKES_UP_PATTERN),
    FALLS_ASLEEP(GuardRecord.FALLS_ASLEEP_PATTERN),
    BEGINS_SHIFT(GuardRecord.BEGINS_SHIFT_PATTERN);

    private final Pattern pattern;

    Status(Pattern pattern) {
        this.pattern = pattern;
    }

    private Pattern getPattern() {
        return pattern;
    }

    static Status of(CharSequence line) throws NoSuchElementException {
        return Arrays.stream(values())
                .filter(status -> status.getPattern().matcher(line).matches())
                .findFirst()
                .orElseThrow();
    }
}
