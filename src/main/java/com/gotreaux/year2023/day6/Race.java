package com.gotreaux.year2023.day6;

import java.util.stream.LongStream;

public record Race(long time, long recordDistance) {
    public Race {
        if (time <= 0 || recordDistance < 0) {
            throw new IllegalArgumentException(
                    "Race expects positive time and non-negative record distance");
        }
    }

    public long getWaysToWin() {
        return LongStream.range(0, time + 1)
                .filter(hold -> hold * (time - hold) > recordDistance)
                .count();
    }
}
