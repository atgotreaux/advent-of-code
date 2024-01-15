package com.gotreaux.aoc.puzzles.year2023.day6;

import java.util.stream.LongStream;

record Race(long time, long recordDistance) {
    Race {
        if (time <= 0L || recordDistance < 0L) {
            throw new IllegalArgumentException(
                    "Race expects positive time and non-negative record distance");
        }
    }

    long getWaysToWin() {
        return LongStream.range(0L, time + 1L)
                .filter(hold -> hold * (time - hold) > recordDistance)
                .count();
    }
}
