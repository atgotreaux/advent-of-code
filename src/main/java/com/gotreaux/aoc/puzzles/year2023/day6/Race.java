package com.gotreaux.aoc.puzzles.year2023.day6;

record Race(long time, long recordDistance) {

    Race {
        if (time <= 0L || recordDistance < 0L) {
            throw new IllegalArgumentException(
                    "Race expects positive time and non-negative record distance");
        }
    }

    long getWaysToWin() {
        var discriminantSquared = time * time - 4.0d * recordDistance;
        if (discriminantSquared < 0.0d) {
            return 0L;
        }
        var discriminant = Math.sqrt(discriminantSquared);

        var lowerRoot = (time - discriminant) / 2.0d;
        var upperRoot = (time + discriminant) / 2.0d;

        var lowerTime = Double.valueOf(Math.floor(lowerRoot)).longValue() + 1L;
        var upperTime = Double.valueOf(Math.ceil(upperRoot)).longValue() - 1L;

        return Math.max(0L, upperTime - lowerTime + 1L);
    }
}
